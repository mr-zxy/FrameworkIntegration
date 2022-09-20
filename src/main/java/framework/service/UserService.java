package framework.service;

import com.github.pagehelper.PageInfo;
import framework.pojo.User;
import framework.pojo.query.UserQuery;

import java.util.List;

public interface UserService {
    public PageInfo<User> userInfo(UserQuery userQuery);
}
