package cn.test.ssmtest.dao;

import cn.test.ssmtest.model.User;

public interface UserDao {

    User selectUser(long id);

}
