package com.briup.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Article;
import com.briup.demo.bean.ArticleExample;
import com.briup.demo.bean.Category;
import com.briup.demo.bean.CategoryExample;
import com.briup.demo.mapper.ArticleMapper;
import com.briup.demo.mapper.CategoryMapper;
import com.briup.demo.service.IArticleServaice;
import com.briup.demo.service.ICategoryService;
import com.briup.demo.utils.CusromerException;
import com.briup.demo.utils.StatusCodeUtil;
@Service
public class ArticleServiceImpl implements IArticleServaice {

	@Autowired
	ArticleMapper articleMapper;
//	@Autowired
//	CategoryMapper categoryMapper;
	@Autowired
	ICategoryService categoryMapper;
	@Override
	public void saveOrUpdateArtical(Article article) throws CusromerException {
		if(article==null) {
			throw new CusromerException(StatusCodeUtil.ERROR_CODE, "参数为空");
		}
		if(article.getId()==null) {
			//需要额外添加2条数据
			article.setPublisurdate(new Date());
			article.setClicktimes((short) 0);
			articleMapper.insert(article);
		}else {
			//article.setPublisurdate(new Date());
			articleMapper.updateByPrimaryKey(article);
		}
	}

	@Override
	public void delectArticalById(Short id) throws CusromerException {
		articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Article> findArticleByCondition(String keystr, String condition) throws CusromerException {
		/*
		 * 1.没有任何条件，查询所有文章
		 * 2.没有指定栏目，指定关键字，查询满足文章
		 * 3.指定栏目但没有关键字，查询栏目下所有文章
		 * 4.指定栏目与关键字，查询指定的满足条件的文章
		 */
		keystr=keystr==null?"":keystr.trim();
		condition=condition==null?"":condition.trim();
		ArticleExample articleExample = new ArticleExample();
		boolean keyeql = "".equals(keystr);
		boolean condeql = "".equals(condition);
		if( keyeql && condeql) {
			//情况1
			return articleMapper.selectByExample(articleExample);
		}
		if(condeql&& !keyeql ) {
			//情况2
			articleExample.createCriteria().andTitleLike("%"+keystr+"%");
			return articleMapper.selectByExample(articleExample);
		}
		if( !condeql&&keyeql) {
			//情况3
//			CategoryExample categoryExample = new CategoryExample();
//			categoryExample.createCriteria().andNameEqualTo(condition);
//			List<Category> categoryie = categoryMapper.selectByExample(categoryExample);
			List<Category> categoryie = categoryMapper.findCategoryByName(condition);
			if(categoryie.size()>0) {
			articleExample.createCriteria().andCategoryIdEqualTo(categoryie.get(0).getId());
			}else {
				throw new CusromerException(StatusCodeUtil.ERROR_CODE, "没有指定的搜索栏目");
			}
			return articleMapper.selectByExample(articleExample);
		}
		if(!keyeql && !condeql) {
			//情况4
			List<Category> categoryie = categoryMapper.findCategoryByName(condition);
			articleExample.createCriteria().andCategoryIdEqualTo(categoryie.get(0).getId())
			.andTitleLike("%"+keystr+"%");
			return articleMapper.selectByExample(articleExample);
		}
		return null;
		
	}

	@Override
	public Article findArticleById(Short id) throws CusromerException {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Article checkArticleByname(String name) throws CusromerException {
		List<Article> findArticleByCondition = this.findArticleByCondition(name, null);
		Article article = findArticleByCondition.get(0);
		Short clicktimes = article.getClicktimes();
		clicktimes = clicktimes== null ? 0 : clicktimes;
		article.setClicktimes(++clicktimes);
		this.saveOrUpdateArtical(article);
		return article;
	}

}
