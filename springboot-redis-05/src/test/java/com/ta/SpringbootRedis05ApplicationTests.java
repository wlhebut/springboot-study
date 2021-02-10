package com.ta;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootRedis05ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    void contextLoads() {

        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);

    }

}
