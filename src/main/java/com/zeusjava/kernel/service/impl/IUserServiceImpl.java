package com.zeusjava.kernel.service.impl;

import com.zeusjava.kernel.entity.User;
import com.zeusjava.kernel.mapper.UserMapper;
import com.zeusjava.kernel.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LittleXuan on 2015/10/17.
 */
@Service("userService")
public class IUserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    public User getUserById(int userId) {
        return this.userMapper.selectUserByUserId(userId);
    }
}
