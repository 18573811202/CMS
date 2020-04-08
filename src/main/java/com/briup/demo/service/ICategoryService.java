package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Category;
import com.briup.demo.bean.Ex.CategoryEx;
import com.briup.demo.utils.CusromerException;

/**
 * 栏目相关的Service层
 * @author 亮澳
 *
 */
public interface ICategoryService {
	/**
	 * 查询所有的栏目
	 */
	public List<Category> findAllCategory() throws CusromerException;
	/**
	 * 添加或修改栏目
	 */
	public void saveOrUpdateCategory(Category category) throws CusromerException;
	/**
	 * 根据id删除栏目信息
	 */
	public void deleteCategoryById(Short id) throws CusromerException;
	/**
	 * 查询相应id的栏目
	 */
	public Category findCategoryById(Short id) throws CusromerException;
	/**
	 * 根据name查询栏目
	 * @param name
	 * @return
	 */
	public List<Category> findCategoryByName(String name) ;
	
 }
