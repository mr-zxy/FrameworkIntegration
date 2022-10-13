package com.framework.service;


import com.framework.pojo.query.UserQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.framework.dao.UserDao;
import com.framework.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   //  交由spring容齐管理
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<User> userInfo(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        return new PageInfo<User>(userDao.userInfo(userQuery));
    }

    @Override
    public List<User> userCreated(User userInfo) {
        userDao.userCreated(userInfo);
        return null;
    }

    @Override
    public void userDeleteById(Integer id) {
        userDao.userDeleteById(id);
    }
}
