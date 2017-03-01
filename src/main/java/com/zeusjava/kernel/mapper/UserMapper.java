package com.zeusjava.kernel.mapper;

import com.zeusjava.kernel.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    User selectUserByUserId(@Param("userId") Integer userId);

    User selectUserByName(@Param("userName") String userName);

    List<User> selectAllUser();

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);



}