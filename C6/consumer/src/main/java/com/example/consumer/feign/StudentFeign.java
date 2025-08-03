package com.example.consumer.feign;

import com.example.common.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

@FeignClient(name = "provider")
public interface StudentFeign {
    @RequestMapping("/student/info")
    Student getStudentInfoById(@RequestParam("studentId") BigInteger studentId);

    @RequestMapping("/student/all")
    List<Student> studentAll();

    @RequestMapping("/student/create")
    String studentCreate(@RequestParam("name") String name,
                         @RequestParam("gender") Integer gender);

    @RequestMapping("/student/update")
    String studentUpdate(@RequestParam("studentId") BigInteger studentId,
                         @RequestParam("name") String name,
                         @RequestParam("gender") Integer gender);

    @RequestMapping("/student/delete")
    String studentDelete(@RequestParam("studentId") BigInteger studentId);
}
