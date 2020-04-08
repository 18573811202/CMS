package com.briup.demo.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.demo.bean.Customer;

public interface CustomerDao  extends JpaRepository<Customer, Short>{
	
	List<Customer> findByusernameAndPassword(String  username,String  password);
}
