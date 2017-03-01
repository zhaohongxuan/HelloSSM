package com.zeusjava.kernel.service.impl;

import com.zeusjava.kernel.entity.User;
import com.zeusjava.kernel.mapper.UserMapper;
import com.zeusjava.kernel.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public Boolean addUser(User user) {
        return userMapper.insertSelective(user) > 0;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }
    @Override
    public Boolean updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }
}
