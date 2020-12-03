package com.example.springboot.controller;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    public void getAllStudents() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/student")
//                .contentType(contentType))
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

//        JSONObject json = new JSONObject(result.getResponse().getContentAsString());
//        System.out.println(json.toString(4));
        System.out.println(result.getResponse().getContentAsString());
    }

}