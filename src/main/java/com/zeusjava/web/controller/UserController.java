package com.zeusjava.web.controller;

/**
 * Created by LittleXuan on 2015/10/18.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/userManage",method = RequestMethod.GET)
    public String getAllUsers(){
        return "userList";
    }

}