package com.itheima.core.dao;

import java.util.List;

import com.itheima.core.po.Customer;

/**
 * Customer接口 
 */
public interface CustomerDao {
	//客户列表
	public List<Customer> selectCustomerList(Customer customer);
	//客户数
	public Integer selectCustomerListCount(Customer customer);
	//创建客户
	public int createCustomer(Customer customer);
}
