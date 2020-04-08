package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Link;
import com.briup.demo.bean.Ex.CategoryEx;
import com.briup.demo.bean.Ex.IndexResult;
import com.briup.demo.service.ICategoryExService;
import com.briup.demo.service.IIndexResultService;
import com.briup.demo.service.ILinkService;

/**查询首页所有数据的实现类
 * @author 亮澳
 *
 */
@Service
public class IndexResultServiceImpl implements IIndexResultService {
	//关联超链接的Service层接口
	@Autowired
	private ILinkService linkService;
	@Autowired
	private ICategoryExService categoryExService;
	@Override
	public IndexResult findIndexAllResult() {
		IndexResult indexResult = new IndexResult();
		//设置所有的超链接信息
		List<Link> links = linkService.findAllLinks();
		indexResult.setInk(links);
		//设置所有的栏目及其包含的文章信息
		List<CategoryEx> categoryExs = categoryExService.findAllCategoryEx();
		indexResult.setCategoryExs(categoryExs);
		return indexResult;
	}

}
