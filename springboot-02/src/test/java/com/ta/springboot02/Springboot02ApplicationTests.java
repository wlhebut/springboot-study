package com.ta.springboot02;

import com.ta.springboot02.mapper.PermissionMapper;
import com.ta.springboot02.mapper.StudentMapper;
import com.ta.springboot02.mapper.UserMapper;
import com.ta.springboot02.pojo.Permission;
import com.ta.springboot02.pojo.Resource;
import com.ta.springboot02.pojo.Student;
import com.ta.springboot02.service.ResourceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//import org.junit.jupiter.api.Test;

@SpringBootTest
class Springboot02ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private ResourceService resourceService;

    @Test
    void contextLoads() {

       /* User lisi = userMapper.queryUserByName("lisi");
        System.out.println(lisi);*/
        List<Permission> permissions = permissionMapper.selectByRole("admin");
        System.out.println(permissions);

    }

    @Test
    void testMapper(){
        Student byId = studentMapper.findById(1);
        System.out.println(byId);
    }

    @Test
    void testResource(){
        List<Resource> all = resourceService.findAll();
        System.out.println(all);
    }

}
