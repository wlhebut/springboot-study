package com.ta.async.controller;

import com.ta.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("asy")
    public String hello() throws InterruptedException {

        String s = asyncService.doSomeThing();

        return "asy";
    }

}
