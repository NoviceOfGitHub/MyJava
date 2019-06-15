package com.whm.First_SpringBoot_M3.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.whm.First_SpringBoot_M3.Dao.UsersMapper;
import com.whm.First_SpringBoot_M3.Service.UserService;
import com.whm.First_SpringBoot_M3.entity.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UsersMapper usersmapper;
 
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Users> FindAll() {
		return usersmapper.selectAll();
	}

	@Override
	public int getstunumber() {
		return usersmapper.gettstunumber();
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Users> stuinfo(int startRecord, int pageSize) {
		return usersmapper.stuinfo(startRecord, pageSize);
	}

	@Override
	public int saveuser(Users users) {
		return usersmapper.insert(users);
	}

	@Override
	public int updateuser(Users users) {
		return usersmapper.updateByPrimaryKey(users);
	}

	@Override
	public int deleteByMPrimaryKey(List<Integer> list) {
		return usersmapper.deleteByMPrimaryKey(list);
	}




	
	
	

}
