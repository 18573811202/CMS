package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CusromerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class CategorySeriveImpl implements ICategoryService {
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Category> findAllCategory() {

		return categoryMapper.selectByExample(new CategoryExample());

	}

	@Override
	public void saveOrUpdateCategory(Category category) throws CusromerException {

		if (category == null) {
			throw new CusromerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		if (category.getId() != null) {
			categoryMapper.updateByPrimaryKey(category);
			return;
		}
		if (this.findCategoryByName(category.getName()).size()!=0) {
			throw new CusromerException(StatusCodeUtil.ERROR_CODE, "已经存在此项目");
		}
		categoryMapper.insert(category);

	}

	@Override
	public void deleteCategoryById(Short id) {
		// 删除栏目的同时，需要先删除栏目中的文章信息
		ArticleExample articleExample = new ArticleExample();
		articleExample.createCriteria().andCategoryIdEqualTo(id);
		articleMapper.deleteByExample(articleExample);
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Category findCategoryById(Short id) throws CusromerException {
		if (id == 0) {
			throw new CusromerException(StatusCodeUtil.ERROR_CODE, "填写的id不能为0");
		}
		return categoryMapper.selectByPrimaryKey(id);
	}

	public List<Category> findCategoryByName(String name) throws CusromerException {
		if (name == null) {
			throw new CusromerException(StatusCodeUtil.ERROR_CODE, "填写的name不能为null");
		}
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.createCriteria().andNameLike("%"+name+"%");
		List<Category> selectByExample = categoryMapper.selectByExample(categoryExample);
		return selectByExample;
	}
}
