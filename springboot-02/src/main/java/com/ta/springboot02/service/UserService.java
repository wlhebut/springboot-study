package com.ta.springboot02.service;

import com.ta.springboot02.pojo.User;

import java.util.List;

public interface UserService {

    public User queryUserByName(String name);

    List<User> findAll();

    void deleteById(Integer id);

}
