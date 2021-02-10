package com.ta.springboot02.controller;

import com.ta.springboot02.mapper.StudentMapper;
import com.ta.springboot02.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
//@Scope("prototype")
public class HelloController {

    private int i = 0;

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private final SqlSession sqlSession;
    @Autowired
    private StudentMapper studentMapper;




    //    页面跳转
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","hello springboot!");
        return "home";
    }


    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello springboot!");
        return "index";
    }


    @GetMapping("safe")
    @ResponseBody
    public int testSafe(){
        return  i++;
    }


    @GetMapping("slow")
    public void testSlow() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("sql * from t_member where  id in (20000,20001,20002,20003,20004,20005,20006,20007)");
        System.out.println(maps);

//        Thread.sleep(600);
    }


    @GetMapping("/student")
    @ResponseBody
    public Student query(){
        Student student = studentMapper.findById(1);
        return student;
    }

}
