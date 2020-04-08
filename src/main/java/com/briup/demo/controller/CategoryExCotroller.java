package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Ex.CategoryEx;
import com.briup.demo.service.ICategoryExService;
import com.briup.demo.utils.CusromerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "级联查询接口")
public class CategoryExCotroller {
	@Autowired
	private ICategoryExService categoryExservice;
	
	@GetMapping("/findAll")
	@ApiOperation("级联查询所有栏目及文章")
	public Message<List<CategoryEx>> findAllcategoryEx(){
		 try {
				return MessageUtil.success(categoryExservice.findAllCategoryEx());
			} catch (CusromerException e) {
				// TODO Auto-generated catch block
				return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
			}
	}
	@GetMapping("/findCategoryExByName")
	@ApiOperation("根据name查询栏目名与相应的文章名")
	public Message<CategoryEx> findCategoryExByName(String name){
		 try {
				return MessageUtil.success(categoryExservice.findCategoryArticle(name));
			} catch (CusromerException e) {
				return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
			}
	}
}
