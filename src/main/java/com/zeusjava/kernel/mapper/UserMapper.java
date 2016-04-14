package com.zeusjava.kernel.mapper;

import com.zeusjava.kernel.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {


    User selectUserByUserId(@Param("userId") Integer userId);

}