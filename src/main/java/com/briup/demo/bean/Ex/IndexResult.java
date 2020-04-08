package com.briup.demo.bean.Ex;

import java.io.Serializable;
import java.util.List;

import com.briup.demo.bean.Link;

/**
 * 保存首页是所有数据
 * @author 亮澳
 *
 */
public class IndexResult implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<CategoryEx> categoryExs;
	private List<Link> ink;
	public List<CategoryEx> getCategoryExs() {
		return categoryExs;
	}
	public void setCategoryExs(List<CategoryEx> categoryExs) {
		this.categoryExs = categoryExs;
	}
	public List<Link> getInk() {
		return ink;
	}
	public void setInk(List<Link> ink) {
		this.ink = ink;
	}
	public IndexResult(List<CategoryEx> categoryExs, List<Link> ink) {
		super();
		this.categoryExs = categoryExs;
		this.ink = ink;
	}
	public IndexResult() {

	}
}
