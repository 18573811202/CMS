package com.briup.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.Ex.CategoryEx;
import com.briup.demo.service.IArticleServaice;
import com.briup.demo.service.ICategoryExService;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CusromerException;
import com.briup.demo.utils.StatusCodeUtil;
@Service
public class CategoryExServiceImpl implements ICategoryExService{
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IArticleServaice articleService;
	@Override
	public List<CategoryEx> findAllCategoryEx() throws CusromerException {
		List<CategoryEx> list = new ArrayList<CategoryEx>() ;
		List<Category> findAllCategory = categoryService.findAllCategory();
		if(findAllCategory==null)
			throw new CusromerException(StatusCodeUtil.ERROR_CODE, "暂无数据");
		for (Category category : findAllCategory) {
			List<Article> findArticle = articleService.findArticleByCondition(null, category.getName());
			CategoryEx categoryEx = new CategoryEx(category.getId(),category.getCode(),category.getName(),findArticle);
			list.add(categoryEx);
		}
		return list;
	}
	@Override
	public CategoryEx findCategoryArticle(String name) throws CusromerException {
		List<Category> findCategoryByName = categoryService.findCategoryByName(name);
		Category category = findCategoryByName.get(0);
		List<Article> findArticleByCondition = articleService.findArticleByCondition(null, name);
		return new CategoryEx(category.getId(),category.getCode(), category.getName(),findArticleByCondition);
	}

}
