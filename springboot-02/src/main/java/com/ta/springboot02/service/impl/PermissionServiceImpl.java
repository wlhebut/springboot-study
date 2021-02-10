package com.ta.springboot02.service.impl;

import com.ta.springboot02.mapper.PermissionMapper;
import com.ta.springboot02.pojo.Permission;
import com.ta.springboot02.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> selectByRole(String role) {

        List<Permission> permissions = permissionMapper.selectByRole(role);
        return permissions;

    }
}
