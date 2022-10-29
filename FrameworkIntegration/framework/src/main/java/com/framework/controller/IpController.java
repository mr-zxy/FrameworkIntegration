package com.framework.controller;

import com.common.core.domain.IpLocation;
import com.common.core.domain.AjaxResult;
import com.common.utils.IpUtils;
import com.framework.pojo.User;
import com.framework.pojo.query.UserQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class IpController {
    @GetMapping("/getIp")
    public String getIp(HttpServletRequest request){
        String ip = IpUtils.getIpAddress(request);
        System.out.println(ip+"-------------");
        return ip;
    }
    @GetMapping("/getCity")
    public String getCity(HttpServletRequest request) throws IOException {
        String ip=getIp(request);
        IpLocation ipLocation=new IpLocation();
        String city = ipLocation.getCityByIp(ip);
        System.out.println(city);
        return city;
    }
}
