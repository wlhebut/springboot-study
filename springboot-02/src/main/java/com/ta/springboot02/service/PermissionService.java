package com.ta.springboot02.service;

import com.ta.springboot02.pojo.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> selectByRole(String role);

}
