package com.example.provider.mapper;

import com.example.common.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE id = #{id} AND is_deleted = 0")
    Student getById(@Param("id") BigInteger id);

    @Select("SELECT * FROM student WHERE is_deleted = 0")
    List<Student> getAll();

    int update(@Param("student") Student student);

    int insert(@Param("student") Student student);

    @Update("UPDATE student SET is_deleted = 1, update_time = #{time} WHERE id = #{id} AND is_deleted = 0 LIMIT 1")
    int delete(@Param("id") BigInteger id, @Param("time") Integer time);
}
