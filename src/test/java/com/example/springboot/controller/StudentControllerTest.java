package com.example.springboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAllStudents() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student")).andReturn();
        System.out.println(result.getResponse().toString());
    }

}