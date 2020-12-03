package com.example.springboot.controller;

import com.example.springboot.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .andExpect(status().isOk())
                .andReturn();

//        JSONObject json = new JSONObject(result.getResponse().getContentAsString());
//        System.out.println(json.toString(4));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void saveStudent() throws Exception{
        Student student = new Student();
        student.setId(528);
        student.setAge(28);
        student.setEmail("danny@bit.com");
        student.setName("danny");
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(student);
        System.out.println("request : " + jsonRequest);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println("response : " + result.getResponse().getContentAsString());

        MvcResult result2 = mockMvc.perform(MockMvcRequestBuilders.get("/student/528")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result2.getResponse().getContentAsString());

        MvcResult result3 = mockMvc.perform(MockMvcRequestBuilders.delete("/student/528")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result3.getResponse().getContentAsString());

    }

}