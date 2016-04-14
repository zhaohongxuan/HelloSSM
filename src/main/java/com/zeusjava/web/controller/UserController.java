package com.zeusjava.web.controller;

/**
 * Created by LittleXuan on 2015/10/18.
 */
import javax.annotation.Resource;

import com.zeusjava.kernel.entity.User;
import com.zeusjava.kernel.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping(value="/userInfo/{id}", method= RequestMethod.GET)
    public String toIndex( Model model,@PathVariable("id") String id) {
        if(StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("id不能为空");
        }
        int userId = Integer.parseInt(id);
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user";
    }
}