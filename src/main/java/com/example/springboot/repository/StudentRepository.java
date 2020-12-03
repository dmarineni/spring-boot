package com.example.springboot.repository;

import com.example.springboot.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
