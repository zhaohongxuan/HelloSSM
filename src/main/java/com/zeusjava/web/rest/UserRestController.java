package com.zeusjava.web.rest;

/**
 * Created by LittleXuan on 2015/10/18.
 */

import com.zeusjava.kernel.entity.User;
import com.zeusjava.kernel.service.IUserService;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
    @Resource
    private IUserService userService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public User toIndex(@PathVariable("id") String id) {
        if(StringUtils.isEmpty(id)){
            throw new IllegalArgumentException("id不能为空");
        }
        int userId = Integer.parseInt(id);
        User user = this.userService.getUserById(userId);
        return user;
    }

    @RequestMapping(value = "/selectAllUser",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public Boolean addUser(@RequestBody User user) {
        if(ObjectUtils.isEmpty(user)){
            return false;
        }
        return userService.addUser(user);
    }

    @RequestMapping(value="/delete", method= RequestMethod.POST)
    public Boolean delete(Integer id) {
       if(id==null){
           return false;
       }
       return userService.deleteUser(id);
    }
}