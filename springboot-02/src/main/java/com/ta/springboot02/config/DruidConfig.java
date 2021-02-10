package com.ta.springboot02.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 初始化Druid连接池
 */
@Configuration  //也可以使用@Configuration，@Configuration包含了@Component
@Slf4j
public class DruidConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid")  //指定前缀
    public DataSource dataSource() {
        return new DruidDataSource();
    }


    @Bean //相当于web.xml
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> statViewServlet = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        Map<String, String> initMap = new HashMap<>();
        initMap.put("loginUsername","admin");
        initMap.put("loginPassword","123456");

        statViewServlet.setInitParameters(initMap);

        return statViewServlet;
    }

}

