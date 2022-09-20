package framework.dao;


import framework.pojo.User;
import framework.pojo.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    public List<User> userInfo(UserQuery userQuery);
}

