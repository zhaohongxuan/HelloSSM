package com.zeusjava.kernel.service.impl;

import com.zeusjava.kernel.dao.UserMapper;
import com.zeusjava.kernel.entity.User;
import com.zeusjava.kernel.service.IUserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LittleXuan on 2015/10/17.
 */
@Service("userService")
public class IUserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }
}
