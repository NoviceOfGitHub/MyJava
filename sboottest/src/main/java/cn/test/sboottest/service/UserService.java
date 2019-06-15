package cn.test.sboottest.service;

import cn.test.sboottest.model.User;

public interface UserService {

    Object listAll(int page, int size);

    int  insert(User user);

    int remove(Integer userId);

    int update(User user);
}
