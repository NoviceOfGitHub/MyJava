package com.itheima.core.service;

import com.itheima.core.po.User;

/**
 * �û�Service��ӿ� 
 */
public interface UserService {
	//ͨ���˺ź������ѯ�û�
	public User findUser(String usercode, String password);
}