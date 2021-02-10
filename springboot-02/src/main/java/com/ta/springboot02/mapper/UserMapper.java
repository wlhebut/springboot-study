package com.ta.springboot02.mapper;


import com.ta.springboot02.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User queryUserByName(String name);

    List<User> findAll();


    void deleteById(Integer id);

}
