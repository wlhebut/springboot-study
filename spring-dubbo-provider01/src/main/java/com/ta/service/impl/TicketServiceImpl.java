package com.ta.service.impl;

import com.ta.service.TicketService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component //尽量不用@Service
public class TicketServiceImpl implements TicketService {


    @Override
    public String getTicket() {

        return "ticket";
    }

}
