package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Ex.CategoryEx;
import com.briup.demo.utils.CusromerException;

public interface ICategoryExService {
	/**
	 * 级联查询出所有的栏目与文章信息
	 * @return
	 * @throws CusromerException
	 */
	public List<CategoryEx> findAllCategoryEx() throws CusromerException;
	/**
	 * 根据name查询栏目及其文章
	 * @param name
	 * @return
	 */
	public CategoryEx findCategoryArticle(String name)throws CusromerException;
}
