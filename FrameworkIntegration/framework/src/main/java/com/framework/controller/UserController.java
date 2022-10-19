package com.framework.controller;

//import com.common.core.domain.AjaxResult;
import com.framework.service.UserService;
import com.github.pagehelper.PageInfo;
import com.framework.pojo.User;
import com.framework.pojo.query.UserQuery;
import com.utils.mehods.Mconstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api(tags=  "商品控制类",value = "这是对该类一个简单描述")
@Controller
public class UserController {

    private String username;

    @Autowired
    private UserService userService;

//    @ApiOperation("返回一个商品")
//    @GetMapping("/userInfo")
//    public AjaxResult userInfo(UserQuery userQuery){
//        AjaxResult ajaxResult=new AjaxResult();
//        PageInfo<User> pageInfo=userService.userInfo(userQuery);
//        ajaxResult.put("list",pageInfo);
//        return ajaxResult.success();
//    }
    @PostMapping("/userCreate")
    public void userCreated(User userInfo){
      System.out.println(userInfo);
      userService.userCreated(userInfo);
    }
    @DeleteMapping("/userDelete/{id}")
    public void userDelete(@PathVariable Integer id){
        userService.userDeleteById(id);
    }

    @RequestMapping("/aa")
    public void testAnnotation(){
        System.out.println(Mconstants._VERSION);
        System.out.println(this.username);
    }

}
