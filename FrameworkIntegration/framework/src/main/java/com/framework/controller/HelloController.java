package com.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/admin")
    public class HelloController {

        @RequestMapping("login.do")
        public String login() {
            System.out.println("11111111");

            return "shell";
        }
    }
