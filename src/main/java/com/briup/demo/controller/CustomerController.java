package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Customer;
import com.briup.demo.service.dao.CustomerDao;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "登录相关接口")
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;

	@GetMapping("/addCustomer")
	@ApiOperation("添加用户")
	public Message addCustomer(Customer customer) {
		try {
			customerDao.save(customer);
			return new MessageUtil().success();
		} catch (Exception e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误" + e.getMessage());
		}
	}

	@GetMapping("/deleteCustomerById")
	@ApiOperation("根据id删除用户")
	public Message deleteCustomerById(Short id) {
		try {
			customerDao.deleteById(id);
			return new MessageUtil().success();
		} catch (Exception e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误" + e.getMessage());
		}
	}
	@GetMapping("/findAllCustomer")
	@ApiOperation("查询所有用户")
	public Message<List<Customer>> findAllCustomer() {
		try {
			List<Customer> findAll = customerDao.findAll();
			return new MessageUtil().success(findAll);
		} catch (Exception e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误" + e.getMessage());
		}
	}
	@GetMapping("/login")
	@ApiOperation("登录查询")
	public Message login(Customer customer) {
		try {
			List<Customer> findByusernameOrPassword = customerDao.findByusernameAndPassword(customer.getUsername(),
					customer.getPassword());
			int size = findByusernameOrPassword.size();
			if (size != 0)
				return new MessageUtil().success();
			else
				return new MessageUtil().error(StatusCodeUtil.ERROR_CODE, "登陆错误");

		} catch (Exception e) {
			return MessageUtil.error(StatusCodeUtil.ERROR_CODE, "系统错误" + e.getMessage());
		}

	}

}
