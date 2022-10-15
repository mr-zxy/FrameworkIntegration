package com.framework.dao;


import com.framework.pojo.User;
import com.framework.pojo.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    public List<User> userInfo(UserQuery userQuery);
    public List<User> userCreated(User userInfo);
    public void userDeleteById(Integer id);
}

