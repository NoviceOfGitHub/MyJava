package com.whm.First_SpringBoot_M3.Service;

import java.util.List;

import com.whm.First_SpringBoot_M3.entity.Users;

public interface UserService {
	//常用意见 --通用设置
	public List<Users> FindAll();
	int getstunumber();
    List<Users> stuinfo(int startRecord,int pageSize);
    int saveuser(Users users);
    int updateuser(Users users);
    int deleteByMPrimaryKey(List<Integer> list);
}
