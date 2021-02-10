package com.ta.springboot02.setting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingController {

    @GetMapping("setting")
    public String base(){
        return "setting";
    }

}

