package com.ta.bean.config;

import com.ta.bean.Person;
import com.ta.bean.condition.LinuxCondition;
import com.ta.bean.condition.MyImportSelector;
import com.ta.bean.condition.WindowsCondition;
import com.ta.bean.pojo.Color;
import com.ta.bean.pojo.ColorFactoryBean;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = "com.ta.bean")

/**
 * {@link Configuration}, {@link ImportSelector}, {@link ImportBeanDefinitionRegistrar}
 * or regular component classes to import.
 *
 * 使用spring 提供的FactoryBean (工厂bean)
 * 1.默认是获取的工厂bean调用getObject创建的对象
 * 2.获取工厂bean本身，需要给id添加一个&
 */
@Import(value = {Color.class, MyImportSelector.class})
public class MainConfig2 {
/*

    如果是windows 注入bill，如果是linux 注入lin
    @Conditional

    */

    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person getPerson(){

        Person person = new Person();
        person.setAge(60);
        person.setName("bill");
        return  person;
    }

    @Bean("lin")
    @Conditional({LinuxCondition.class})
    public Person getPerson2(){

        Person person = new Person();
        person.setAge(19);
        person.setName("lin");
        return  person;
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
      return new ColorFactoryBean();
    }

}
