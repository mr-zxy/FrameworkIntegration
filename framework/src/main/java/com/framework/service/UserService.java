package com.framework.service;

import com.github.pagehelper.PageInfo;
import com.framework.pojo.User;
import com.framework.pojo.query.UserQuery;

import java.util.List;

public interface UserService {
    public PageInfo<User> userInfo(UserQuery userQuery);
    public List<User> userCreated(User userInfo);
    public void userDeleteById(Integer id);
}
