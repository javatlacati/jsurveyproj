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
class SurveyTemplateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findById() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/template/1")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        System.out.println("template 1: " + action.andReturn().getResponse().getContentAsString());
    }

    @Test
    void findAll() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/templates")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        System.out.println("templates: " + action.andReturn().getResponse().getContentAsString());
    }
}
