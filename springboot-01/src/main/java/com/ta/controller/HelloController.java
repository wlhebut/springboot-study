package com.ta.controller;

import com.ta.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@Slf4j
public class HelloController {

    private  static  int  st =  0 ;       //静态的
    private  int  index =  0 ;     //非静态
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private HelloService helloService;

//    页面跳转
    @GetMapping("/hello")
    public String hello(Model model){

        System.out.println(st++ +  " | "  + index++);
        System.out.println(HelloController.class.hashCode());

        model.addAttribute("msg",st +  " | "  + index);

        return "home";
    }


    @GetMapping("safe")
    @ResponseBody
    public int testSafe(){
        return  0;
    }


    @GetMapping("slow")
    @ResponseBody
    public void testSlow() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select  * from t_member where  id in (117108,217101,317102,417103,317104,317105,317106,317107,317108,317109)");
    }
    @GetMapping("slow1")
    @ResponseBody
    public void testSlow1() throws InterruptedException {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM t_member WHERE user_name IN ('ktngtzso','ixmtijux','utgakxgp','oxvkptyo','rqezjwfl','vdieyffl','jgebuset','bnmulykd','hvidrxpf','zwklzriq','yrmlracl','zmmyfgqi')");
        log.info(maps.toString());

    }
    @GetMapping("slow2")
    @ResponseBody
    public void testSlow2() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select  * from t_member where  id in (117108,217101,317102,417103,317104,317105,317106,317107,317108,317109)");
    }
    @GetMapping("slow3")
    @ResponseBody
    public void testSlow3() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT COUNT(1) FROM t_member WHERE id > 10000");
    }
    @GetMapping("slow4")
    @ResponseBody
    public void testSlow4() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT COUNT(1) FROM t_member WHERE id > 200000");
    }
    @GetMapping("slow5")
    @ResponseBody
    public void testSlow5() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT COUNT(1) FROM t_member WHERE id > 300000");
    }
    @GetMapping("slow6")
    @ResponseBody
    public void testSlow6() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT COUNT(1) FROM t_member WHERE id > 400000");
    }
    @GetMapping("slow7")
    @ResponseBody
    public void testSlow7() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT COUNT(1) FROM t_member WHERE id > 500000");
    }
    @GetMapping("slow8")
    @ResponseBody
    public void testSlow8() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT COUNT(1) FROM t_member WHERE id > 41000");
    }
    @GetMapping("slow9")
    @ResponseBody
    public void testSlow9() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT COUNT(1) FROM t_member");
    }
    @GetMapping("slow10")
    @ResponseBody
    public void testSlow10() throws InterruptedException {

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM t_member WHERE register_date > '2016-07-01 00:00:00'");
    }







}
