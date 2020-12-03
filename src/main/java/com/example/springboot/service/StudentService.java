package com.example.springboot.service;

import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        repository.findAll().forEach(student -> students.add(student));
        return students;
    }

    public Student getById(int id){
        return repository.findById(id).get();
    }

    public void saveOrUpdate(Student student){
        repository.save(student);
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }
}
