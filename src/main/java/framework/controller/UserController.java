package framework.controller;

import com.github.pagehelper.PageInfo;
import framework.pojo.User;
import framework.pojo.query.UserQuery;
import framework.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags=  "商品控制类",value = "这是对该类一个简单描述")
@RequestMapping("/goods")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("返回一个商品")
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
