package com.ta.springboot02.mapper;

import com.ta.springboot02.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {

    List<Permission> selectByRole(String id);


}
