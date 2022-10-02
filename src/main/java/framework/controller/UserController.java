package framework.controller;

import com.github.pagehelper.PageInfo;
import framework.pojo.User;
import framework.pojo.query.UserQuery;
import framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/userInfo")
    public PageInfo<User> userInfo(UserQuery userQuery){
        return userService.userInfo(userQuery);
    }
    @PostMapping("/userCreate")
    public void userCreated(User userInfo){
      System.out.println(userInfo);
      userService.userCreated(userInfo);
    }
    @DeleteMapping("/userDelete/{id}")
    public void userDelete(@PathVariable Integer id){
        userService.userDeleteById(id);
    }
}
