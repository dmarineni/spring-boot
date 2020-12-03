package com.example.springboot.controller;

import com.example.springboot.model.Student;
import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/student")
    private List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
