package com.auefly.dao;

import com.auefly.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select(value = "SELECT * FROM user")
    List<User> list();
}
