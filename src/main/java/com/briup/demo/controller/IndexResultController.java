package com.briup.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Ex.IndexResult;
import com.briup.demo.service.IIndexResultService;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "显示所有信息")
public class IndexResultController {

	@Autowired
	private IIndexResultService indexResultService;
	@GetMapping("/findAllIndexResult")
	@ApiOperation("查询所有数据")
	public Message<IndexResult> findAllIndexResult(){
		
		try {
			IndexResult findIndexAllResult = indexResultService.findIndexAllResult();
			return MessageUtil.success(findIndexAllResult);
		} catch (Exception e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误"+e.getMessage());
		}
		
	}
}
