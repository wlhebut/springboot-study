package com.ta.bean.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

@Slf4j
public class MyTypeFilter implements TypeFilter {


    @Override

    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

//        log.info("123");
//        获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();

        log.info("--->annotationMetadata ：{}",annotationMetadata);
        log.info("--->resource： {}",resource);
        log.info("--->className：{}",className);

        log.info("--------------------------------------------------");

        return false;
    }
}
