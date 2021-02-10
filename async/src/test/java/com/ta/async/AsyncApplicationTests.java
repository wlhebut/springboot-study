package com.ta.async;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;

@SpringBootTest
class AsyncApplicationTests {

    @Resource
    private JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("subject");
        mailMessage.setText("nihao!");
        mailMessage.setTo("584529403@qq.com");
        mailMessage.setFrom("584529403@qq.com");

        javaMailSender.send(mailMessage);

    }

}
