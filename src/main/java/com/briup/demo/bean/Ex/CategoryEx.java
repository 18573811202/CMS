package com.briup.demo.bean.Ex;

import java.io.Serializable;
import java.util.List;

import com.briup.demo.bean.Article;

import io.swagger.annotations.ApiParam;

/**
 * @author 亮澳
 * 栏目的扩展类
 * 除了栏目还级联保存对应文章信息
 */
public class CategoryEx implements Serializable{

	private static final long serialVersionUID = 1L;

	    private Short id;
	    @ApiParam(value="栏目号",required=true)
	    private Short code;
	    @ApiParam(value="栏目名",required=true)
	    private String name;
	    //添加级联的所有文章
	    private List<Article> article;
		public Short getId() {
			return id;
		}
		public void setId(Short id) {
			this.id = id;
		}
		public Short getCode() {
			return code;
		}
		public void setCode(Short code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Article> getArticle() {
			return article;
		}
		public void setArticle(List<Article> article) {
			this.article = article;
		}
	    public CategoryEx() {

	    }
		public CategoryEx(Short id, Short code, String name, List<Article> article) {
			super();
			this.id = id;
			this.code = code;
			this.name = name;
			this.article = article;
		}
	    

}
