package com.ta.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public String doSomeThing() throws InterruptedException {

        Thread.sleep(1000);
        return "async";
    }
}
