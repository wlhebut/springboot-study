package com.ta.bean.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

@Slf4j
public class ColorFactoryBean implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {

        log.info("ColorFactoryBean--->create");

        return new Color();
    }

    @Override
    public Class<?> getObjectType() {

        return Color.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
