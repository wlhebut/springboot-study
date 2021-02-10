package com.ta.springboot02.service.impl;

import com.ta.springboot02.mapper.UserMapper;
import com.ta.springboot02.pojo.User;
import com.ta.springboot02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User queryUserByName(String name) {

        User user = userMapper.queryUserByName(name);
        return user;

    }

    @Override
    public List<User> findAll() {

        List<User> all = userMapper.findAll();
        return all;

    }

    @Override
    public void deleteById(Integer id) {

        userMapper.deleteById(id);

    }

}
