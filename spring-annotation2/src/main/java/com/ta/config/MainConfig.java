package com.ta.config;

import com.ta.pojo.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ta.pojo")
public class MainConfig {

    @Bean
    public Cat cat(){
        return new Cat();
    }
}
