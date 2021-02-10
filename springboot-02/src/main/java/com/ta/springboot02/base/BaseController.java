package com.ta.springboot02.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("base")
    public String base(){
        return "base";
    }
}
