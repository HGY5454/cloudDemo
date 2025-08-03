package com.example.provider.controller;

import com.example.common.entity.Student;
import com.example.provider.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/student/info")
    public Student studentInfo(@RequestParam(name = "studentId") BigInteger studentId) {
        return service.getStudentInfoById(studentId);
    }

    @RequestMapping("/student/all")
    public List<Student> studentAll() {
        return service.getAllStudentInfo();
    }

    @RequestMapping("/student/create")
    public String studentCreate(@RequestParam(name = "name") String name,
                                @RequestParam(name = "gender") Integer gender) {
        int result = service.createStudent(name, gender);
        return result == 1 ? "success" : "fail";
    }

    @RequestMapping("/student/update")
    public String studentUpdate(@RequestParam(name = "studentId") BigInteger studentId,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "gender") Integer gender) {
        int result = service.updateStudent(studentId, name, gender);
        return result == 1 ? "success" : "fail";
    }

    @RequestMapping("/student/delete")
    public String studentDelete(@RequestParam(name = "studentId") BigInteger studentId) {
        int result = service.deleteStudent(studentId);
        return result == 1 ? "success" : "fail";
    }
}
