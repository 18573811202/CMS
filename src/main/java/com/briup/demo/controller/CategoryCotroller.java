package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Category;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CusromerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "栏目相关接口")
public class CategoryCotroller {
	@Autowired
	private ICategoryService categorySerive;

	@PostMapping("/saveOrUpdateCategory")
	@ApiOperation("新增栏目或更新栏目")
	public Message<String> saveOrUpdateCategory(Category category) {
		try {
			categorySerive.saveOrUpdateCategory(category);
			return MessageUtil.success();
		} catch (CusromerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}
	}

	@GetMapping("/deleteCategoryById")
	@ApiOperation("删除栏目")
	public Message<String> deleteCategoryById(Short id) {
		categorySerive.deleteCategoryById(id);
		return MessageUtil.success();

	}

	@GetMapping("/findAllCategory")
	@ApiOperation("查询所有栏目")
	public Message<List<Category>> findAllCategory() {

		return MessageUtil.success(categorySerive.findAllCategory());
	}

	@GetMapping("/findCategoryById")
	@ApiOperation("根据id查栏目")
	public Message<Category> findCategoryById(Short id) {
		try {
			return MessageUtil.success(categorySerive.findCategoryById(id));
		} catch (CusromerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}
	}
	@GetMapping("/findCategoryByName")
	@ApiOperation("根据name查栏目")
	public Message<List<Category>> findCategoryByName(String name) {
		try {
			List<Category> findCategoryByName = categorySerive.findCategoryByName(name);
			return MessageUtil.success();
		} catch (CusromerException e) {
			// TODO Auto-generated catch block
			return MessageUtil.error(e.getCode(), "系统错误" + e.getMessage());
		}
	}

}
