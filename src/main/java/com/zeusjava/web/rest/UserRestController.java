package com.zeusjava.web.rest;

/**
 * Created by LittleXuan on 2015/10/18.
 */

import com.zeusjava.kernel.entity.User;
import com.zeusjava.kernel.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
    @Resource
    private IUserService userService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<User> findUser(@PathVariable("id") int id) {
        User user = this.userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUser();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value="/", method= RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User userExist = userService.getUserByUserName(user.getUserName());
        if (userExist != null) {
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            userService.addUser(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<User> delete(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.deleteUser(id);
            return new ResponseEntity<>(user,HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody User user){
        User currentUser = userService.getUserById(id);
        HttpStatus httpStatus;
        if (currentUser != null) {
            currentUser.setPassword(user.getPassword());
            currentUser.setUserName(user.getUserName());
            boolean result = userService.updateUser(user);
            if (result) {
                httpStatus = HttpStatus.OK;
            } else {
                httpStatus = HttpStatus.NO_CONTENT;
            }
            return new ResponseEntity<>(currentUser, httpStatus);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}