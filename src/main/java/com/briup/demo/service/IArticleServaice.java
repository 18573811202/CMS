package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Article;
import com.briup.demo.utils.CusromerException;

/**
 * 文章相关内容Service
 * @author 亮澳
 *
 */
public interface IArticleServaice {
	/**
	 * 新增或修改文章
	 */
	public void saveOrUpdateArtical(Article article)throws CusromerException;
	/**
	 * 删除文章
	 */
	public void delectArticalById(Short id) throws CusromerException;
	/**
	 * 查询所有文章
	 */
	public List<Article> findArticleByCondition(String keystr,String condition)throws CusromerException;
	/**
	 * 根据id查询文章
	 */
	public Article findArticleById(Short id)throws CusromerException;
	/**
	 * 查看文章根据姓名 并更新浏览次数
	 * @param name
	 * @return
	 * @throws CusromerException
	 */
	public Article checkArticleByname(String name) throws CusromerException;
}
