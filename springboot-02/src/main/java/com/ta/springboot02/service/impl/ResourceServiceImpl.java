package com.ta.springboot02.service.impl;

import com.ta.springboot02.mapper.ResourceMapper;
import com.ta.springboot02.pojo.Resource;
import com.ta.springboot02.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public List<Resource> findAll() {

        List<Resource> all = resourceMapper.findAll();
        return all;

    }

}
