package com.ta.bean.pojo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Car {

    public Car(){
        log.info("Car() constructor。。。");

    }

    public void init(){
        log.info("Car() init。。。");
    }
    public void detory(){
        log.info("Car() detory。。。");
    }

}
