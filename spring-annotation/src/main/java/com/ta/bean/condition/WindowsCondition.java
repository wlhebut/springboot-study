package com.ta.bean.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Slf4j
public class WindowsCondition  implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        log.info("metadata--->{}",metadata);

        Class<? extends AnnotatedTypeMetadata> aClass = metadata.getClass();
        log.info("metadata.getClass();--->{}",aClass);


        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        ClassLoader classLoader = context.getClassLoader();

        Environment environment = context.getEnvironment();

        BeanDefinitionRegistry registry = context.getRegistry();

        ResourceLoader resourceLoader = context.getResourceLoader();
        String property = environment.getProperty("os.name");

        if(property.contains("Windows")){
            return true;
        }

        return false;

    }
}
