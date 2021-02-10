package com.ta.springboot02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    配置swagger bean 实例

    @Bean
    public Docket docketZhangSan(Environment environment){

        Profiles dev = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(dev);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("zhangsan")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ta.springboot02.base"))
                .build();

    }
    @Bean
    public Docket docketWangLiang(Environment environment){

        Profiles dev = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(dev);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .groupName("wangliang")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ta.springboot02.setting"))
                .build();

    }

    private ApiInfo apiInfo(){

        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                new Contact("", "www.baidu.com", ""),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }

}
