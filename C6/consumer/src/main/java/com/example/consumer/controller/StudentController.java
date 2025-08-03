package com.example.consumer.controller;

import com.example.common.entity.Student;
import com.example.consumer.feign.StudentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    public StudentFeign studentFeign;

    @RequestMapping("/student/info")
    public Student studentInfo(@RequestParam(name = "studentId") BigInteger studentId) {
        return studentFeign.getStudentInfoById(studentId);
    }

    @RequestMapping("/student/all")
    public List<Student> studentAll() {
        return studentFeign.studentAll();
    }

    @RequestMapping("/student/create")
    public String studentCreate(@RequestParam(name = "name") String name,
                                @RequestParam(name = "gender") Integer gender) {
        return studentFeign.studentCreate(name, gender);
    }

    @RequestMapping("/student/update")
    public String studentUpdate(@RequestParam(name = "studentId") BigInteger studentId,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "gender") Integer gender) {
        return studentFeign.studentUpdate(studentId, name, gender);
    }

    @RequestMapping("/student/delete")
    public String studentDelete(@RequestParam(name = "studentId") BigInteger studentId) {
        return studentFeign.studentDelete(studentId);
    }
}
