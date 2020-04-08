package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Link;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CusromerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 与链接相关 和前端交互的web层
 * 
 * @author 亮澳
 *
 */
@RestController

public class LinkController {
	@Autowired
	private ILinkService linkService;

	@PostMapping("/addLink")
	@ApiOperation("新增链接")
	public Message<String> addLink(Link link) {
		try {
			linkService.saveLink(link);
			return MessageUtil.success();
		} catch (CusromerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}
	}
	@PostMapping("/upLink")
	@ApiOperation("更新链接")
	public Message<String> upLink(Link link) {
		try {
			linkService.upLink(link);
			return MessageUtil.success();
		} catch (CusromerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}
	}
	@GetMapping("/queryLink")
	@ApiOperation("名字查询链接")
	public Message<List<Link>> queryLink(String name) {
		try {
			List<Link> queryLink = linkService.queryLink(name);
			return MessageUtil.success(queryLink);
		} catch (CusromerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}
	}
	@GetMapping("/queryAll")
	@ApiOperation("查询所有链接")
	public Message<List<Link>> findAllLinks() {
			List<Link> findAllLinks = linkService.findAllLinks();
			return MessageUtil.success(findAllLinks);
	}
	@GetMapping("/delLink")
	@ApiOperation("删除链接")
	public Message<String> delLink(Short id) {
			linkService.delLink(id);
			return MessageUtil.success();
	}
}
