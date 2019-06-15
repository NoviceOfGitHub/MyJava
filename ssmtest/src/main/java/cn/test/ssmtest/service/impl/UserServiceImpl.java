package cn.test.ssmtest.service.impl;

import cn.test.ssmtest.dao.UserDao;
import cn.test.ssmtest.model.User;
import cn.test.ssmtest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User selectUser(long userId){
        return userDao.selectUser(userId);
    }

}
