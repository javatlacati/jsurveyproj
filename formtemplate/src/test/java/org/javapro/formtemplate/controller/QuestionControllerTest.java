package org.javapro.formtemplate.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/questions")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        System.out.println("questions: "+action.andReturn().getResponse().getContentAsString());
    }

    @Test
    void findById() throws Exception {
        ResultActions action =  mockMvc.perform(MockMvcRequestBuilders.get("/question/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        System.out.println("question: "+action.andReturn().getResponse().getContentAsString());

    }
}