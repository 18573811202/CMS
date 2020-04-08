package com.briup.demo.service;

import com.briup.demo.bean.Ex.IndexResult;

/**
 * 数据管理的Service层接口
 * @author 亮澳
 *
 */
public interface IIndexResultService {
	/**
	 * 查询首页需要的所有数据
	 * @return
	 */
	public IndexResult findIndexAllResult();
}
