package com.ta.springboot02.mapper;

import com.ta.springboot02.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {

//    @Select("select * from student where id = #{id}")
    Student findById(int id);

}
