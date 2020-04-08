package com.briup.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Link;
import com.briup.demo.bean.LinkExample;
import com.briup.demo.bean.LinkExample.Criteria;
import com.briup.demo.mapper.LinkMapper;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CusromerException;
import com.briup.demo.utils.StatusCodeUtil;

/**
 * 操作连接的service功能类
 * @author 亮澳
 *
 */
@Service
public class LinkServiceImpl implements ILinkService{
	@Autowired
	private LinkMapper linkMapper;
	@Override
	public void saveLink(Link link) throws CusromerException {
		if(link==null) {
			throw new CusromerException(StatusCodeUtil.ERROR_CODE, "参数为空！");
		}
		
		linkMapper.insert(link);
	}
	@Override
	public void upLink(Link link) throws CusromerException {
		if(link==null) {
			throw new CusromerException(StatusCodeUtil.ERROR_CODE, "参数为空！");
		}
		linkMapper.updateByPrimaryKey(link);
		
	}
	@Override
	public List<Link> queryLink(String name) throws CusromerException {
		name=name==null?"":name.trim();
		LinkExample linkExample = new LinkExample();
		if("".equals(name)) {
			//如果搜索条件吗没有，则返回所有数据
			return linkMapper.selectByExample(linkExample);
		}else {
			//如果搜索不是空，返回满足条件的数据
		Criteria createCriteria = linkExample.createCriteria();
		 createCriteria.andNameLike("%"+name+"%");
		return linkMapper.selectByExample(linkExample);
		}
	}
	@Override
	public void delLink(Short id) throws CusromerException {
		linkMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<Link> findAllLinks() throws CusromerException {
		LinkExample linkExample = new LinkExample();
		List<Link> selectByExample = linkMapper.selectByExample(linkExample);
		return selectByExample;
	}
	

}
