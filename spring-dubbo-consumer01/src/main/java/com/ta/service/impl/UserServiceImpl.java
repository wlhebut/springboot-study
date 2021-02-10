package com.ta.service.impl;

import com.ta.service.TicketService;
import com.ta.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Reference
    private TicketService ticketService;


    @Override
    public void buyTicket() {
        String ticket = ticketService.getTicket();
        System.out.println(ticket);
        System.out.println("在注册中心拿到了 数据");
    }
}
