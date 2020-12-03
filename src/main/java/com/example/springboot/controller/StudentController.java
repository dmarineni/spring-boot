package com.example.springboot.controller;

import com.example.springboot.model.Student;
import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/student")
    private List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    private int saveStudent(@RequestBody Student student){
        studentService.saveOrUpdate(student);
        return student.getId();
    }

    @RequestMapping("/student/{id}")
    private Student getStudentById(@PathVariable("id") int id){
        return studentService.getById(id);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    private void deleteById(@PathVariable("id") int id){
        studentService.deleteById(id);
    }
}
