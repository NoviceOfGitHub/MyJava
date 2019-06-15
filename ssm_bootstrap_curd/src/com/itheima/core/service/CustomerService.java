package com.itheima.core.service;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Customer;

public interface CustomerService {
	//查询客户列表
	public Page<Customer> findCustomerList(Integer page, Integer rows, 
			String custName, String custSource, String custIndustry, String custLevel);
	
	public int createCustomer(Customer customer);
}
