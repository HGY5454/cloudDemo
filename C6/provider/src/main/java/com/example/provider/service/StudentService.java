package com.example.provider.service;

import com.example.common.entity.Student;
import com.example.provider.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Service
public class StudentService {

    @Resource
    private StudentMapper mapper;

    public Student getStudentInfoById(BigInteger id) {
        return mapper.getById(id);
    }

    public List<Student> getAllStudentInfo() {
        return mapper.getAll();
    }

    public int createStudent(String name, Integer gender) {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setCreateTime(timestamp);
        student.setUpdateTime(timestamp);
        student.setIsDeleted(0);
        return mapper.insert(student);
    }

    public int updateStudent(BigInteger studentId, String name, Integer gender) {
        int timestamp = (int) (System.currentTimeMillis() / 1000);
        Student student = new Student();
        student.setId(studentId);
        student.setName(name);
        student.setGender(gender);
        student.setUpdateTime(timestamp);
        return mapper.update(student);
    }

    public int deleteStudent(BigInteger id) {
        return mapper.delete(id, (int) (System.currentTimeMillis() / 1000));
    }
}
