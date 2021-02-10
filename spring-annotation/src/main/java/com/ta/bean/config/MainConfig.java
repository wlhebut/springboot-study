package com.ta.bean.config;

import com.ta.bean.Person;
import org.springframework.context.annotation.*;

@Configuration
//Filter[] excludeFilters

/*
排除
@ComponentScan(value = "com.ta.bean",
        excludeFilters={
                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
        })
*/

//只扫描
/*
@ComponentScan(value = "com.ta.bean",
        includeFilters={
            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
        },useDefaultFilters = false)

        */
@ComponentScan(value = "com.ta.bean",
        includeFilters={
            @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },useDefaultFilters = false)

public class MainConfig {

//    @Bean(value = "person2")

    @Bean("person")
//    @Scope(scopeName="prototype")多例，默认单例
    public Person getPerson(){

        Person person = new Person();
        person.setAge(19);
        person.setName("zhangheng");
        System.out.println("person--->create");
        return  person;
    }

}
