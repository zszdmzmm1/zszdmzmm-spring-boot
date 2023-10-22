package com.auefly.service;


import com.auefly.dao.UserMapper;
import com.auefly.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IService {
    @Autowired
    UserMapper mapper;
    @Override
    public List<User> selectUser() {
        return mapper.list();
    }
}
