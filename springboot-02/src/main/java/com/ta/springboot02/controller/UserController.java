package com.ta.springboot02.controller;

import com.ta.springboot02.pojo.User;
import com.ta.springboot02.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/toUnauthorized")
    public String toUnauthorized(Model model){
        model.addAttribute("msg","未授权！");
        return "unauthorized";
    }

    @GetMapping("/loginOut")
    public String  loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    @GetMapping("user/{name}")
    @ResponseBody
    public User queryUserByName(@PathVariable("name") String name) {

        User user = userService.queryUserByName(name);

        return user;
    }



    @GetMapping("/home")
    public String toHome(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        try {
            subject.login(usernamePasswordToken);
            return "index";//登陆成功返回首页
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误！");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误！");
            return "login";
        }catch (Exception e){
            model.addAttribute("msg","内部错误！");
            return "login";
        }

    }


    @GetMapping("/user/add")
    public String toAdd(){
        return "user/add";
    }

    @GetMapping("/user/list")
    public String toList(Model model){
        List<User> all = userService.findAll();
        model.addAttribute("list",all);
        return "user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "forward:/user/list";
    }

    @GetMapping("/user/update")
    public String toUpdate(){
        return "user/update";
    }




}
