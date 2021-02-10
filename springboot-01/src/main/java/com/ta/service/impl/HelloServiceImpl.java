package com.ta.service.impl;

import com.ta.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello() {

        int i = HelloServiceImpl.class.hashCode();

        return "HelloServiceImpl.class.hashCode(): "+i;

    }

}
