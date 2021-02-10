package com.ta.bean.config;

import com.ta.bean.pojo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "detory")
    public Car car(){
        return new Car();
    }

}
