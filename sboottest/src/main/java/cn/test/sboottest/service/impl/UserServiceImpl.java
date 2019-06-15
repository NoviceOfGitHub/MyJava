package cn.test.sboottest.service.impl;

import cn.test.sboottest.dao.UserDao;
import cn.test.sboottest.model.User;
import cn.test.sboottest.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Object listAll(int page, int size) {
        PageHelper.startPage(page, size);
        List<User> userList = userDao.listAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public int insert(User user) {
       return userDao.insert(user);
    }

    @Override
    public int remove(Integer userId) {
        return userDao.remove(userId);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}
