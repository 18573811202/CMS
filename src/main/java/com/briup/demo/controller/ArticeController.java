package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Article;
import com.briup.demo.service.IArticleServaice;
import com.briup.demo.utils.CusromerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 亮澳 文章相关信息的controller
 */
@RestController
@Api(description = "文章相关接口")
public class ArticeController {
	@Autowired
	private IArticleServaice articleService;

	@PostMapping("/addArticle")
	@ApiOperation("添加或更新文章")
	public Message<String> saveArticle(Article article) {
		try {
			articleService.saveOrUpdateArtical(article);
			return MessageUtil.success();
		} catch (CusromerException e) {
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}
	}

	@PostMapping("/updateArticle")
	@ApiOperation("修改文章")
	public Message<String> upArticle(Article article) {
		try {
			articleService.saveOrUpdateArtical(article);
			return MessageUtil.success();
		} catch (CusromerException e) {
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}
	}

	@GetMapping("/deleteArticle")
	@ApiOperation("删除文章")
	public Message<String> deleteArticle(Short id) {

		articleService.delectArticalById(id);
		return MessageUtil.success();
	}

	@GetMapping("/findArticle")
	@ApiOperation("条件查询文章")
	public Message<List<Article>> selectArticle(String keystr, String condition) {

		try {
			List<Article> findArticleByCondition = articleService.findArticleByCondition(keystr, condition);
			return MessageUtil.success(findArticleByCondition);
		} catch (CusromerException e) {
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}

	}

	@GetMapping("/findArticleById")
	@ApiOperation("id查询文章")
	public Message<Article> selectArticleById(Short id) {
		Article findArticleByCondition = articleService.findArticleById(id);
		return MessageUtil.success(findArticleByCondition);

	}
	@GetMapping("/checkArticleByname")
	@ApiOperation("查看文章")
	public Message<Article> checkArticleByname(String name) {
		try {
			Article findArticleByCondition = articleService.checkArticleByname(name);
			return MessageUtil.success(findArticleByCondition);
		} catch (CusromerException e) {
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}

	}
}
