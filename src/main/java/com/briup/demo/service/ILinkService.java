package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Link;
import com.briup.demo.utils.CusromerException;

/**
 * 关于链接的sercice层
 * @author 亮澳
 *
 */

public interface ILinkService {
	/**
	 * 保存链接信息
	 * @param link
	 */
	void saveLink(Link link) throws CusromerException;
	/**
	 * 
	 * @param link
	 * @throws CusromerException
	 */
	void upLink(Link link) throws CusromerException;
	/**
	 * 查询链接信息
	 * @param id
	 * @return
	 * @throws CusromerException
	 */
	List<Link> queryLink(String name) throws CusromerException;
	/**
	 * 删除链接信息
	 * @param id
	 * @throws CusromerException
	 */
	void delLink(Short id) throws CusromerException;
	/**
	 * 查询所有链接
	 * @return
	 * @throws CusromerException
	 */
	List<Link> findAllLinks() throws  CusromerException;
}
