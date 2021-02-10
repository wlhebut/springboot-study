package com.ta.springboot02.mapper;

import com.ta.springboot02.pojo.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResourceMapper {

    List<Resource> findAll();

}
