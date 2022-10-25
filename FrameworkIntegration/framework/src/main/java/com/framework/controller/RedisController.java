package com.framework.controller;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;
    @GetMapping("/hello2")
    public int hello2(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("counter", 1);
        return (int) valueOperations.get("counter");
    }
    @GetMapping("/hello1")
    public String hello1(){

        return "docker 部署成功";
    }
    @GetMapping("/hello")
    public int show(){
        ValueOperations valueOperations = redisTemplate.opsForValue();

        int v= (int) valueOperations.get("counter");
        v+=1;
        valueOperations.set("counter",  v);
        return (int) valueOperations.get("counter");
    }
}

