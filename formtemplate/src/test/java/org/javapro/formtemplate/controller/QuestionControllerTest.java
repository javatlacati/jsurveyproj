package org.javapro.formtemplate.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/questions")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        System.out.println("questions: " + action.andReturn().getResponse().getContentAsString());
    }

    @Test
    void findById() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/question/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        System.out.println("question: " + action.andReturn().getResponse().getContentAsString());

    }

    @Test
    void deleteById() throws Exception {
        ResultActions action = mockMvc.perform(
                MockMvcRequestBuilders.post("/question")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"questionId\": null,\n" +
                                "  \"statement\": \"nombre\",\n" +
                                "  \"required\": true,\n" +
                                "  \"type\": \"OPEN\"\n" +
                                "}")
        ).andExpect(status().isOk());
        System.out.println("question: " + action.andReturn().getResponse().getContentAsString());
        mockMvc.perform(MockMvcRequestBuilders.delete("/question/5")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        ResultActions action2 = mockMvc.perform(MockMvcRequestBuilders.get("/question/5")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        System.out.println("question: " + action2.andReturn().getResponse().getContentAsString());

    }

    @Test
    void createOpenQuestion() throws Exception {
        ResultActions action = mockMvc.perform(
                MockMvcRequestBuilders.post("/question")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"questionId\": null,\n" +
                                "  \"statement\": \"nombre\",\n" +
                                "  \"required\": true,\n" +
                                "  \"type\": \"OPEN\"\n" +
                                "}")
        ).andExpect(status().isOk());
        System.out.println("question: " + action.andReturn().getResponse().getContentAsString());
    }

    @Test
    void createDateQuestion() throws Exception {
        ResultActions action = mockMvc.perform(
                MockMvcRequestBuilders.post("/question")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"questionId\": null,\n" +
                                "  \"statement\": \"Fecha actual\",\n" +
                                "  \"required\": true,\n" +
                                "  \"type\": \"DATE\"\n" +
                                "}")
        ).andExpect(status().isOk());
        System.out.println("question: " + action.andReturn().getResponse().getContentAsString());
    }

    @Test
    void createMultipleOptionQuestion() throws Exception {
        ResultActions action = mockMvc.perform(
                MockMvcRequestBuilders.post("/question")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"questionId\": null,\n" +
                                "  \"statement\": \"SEXO\",\n" +
                                "  \"required\": true,\n" +
                                "  \"type\": \"MULTIPLE_OPTION\",\n" +
                                "  \"answerOptions\": [\n" +
                                "    \"M\",\n" +
                                "    \"F\"\n" +
                                "  ]\n" +
                                "}")
        ).andExpect(status().isOk());
        System.out.println("question: " + action.andReturn().getResponse().getContentAsString());
        //TODO fix creation
    }

    @Test
    void updateOpenQuestion() throws Exception {
        ResultActions action = mockMvc.perform(
                MockMvcRequestBuilders.post("/question")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"questionId\": null,\n" +
                                "  \"statement\": \"nombre\",\n" +
                                "  \"required\": true,\n" +
                                "  \"type\": \"OPEN\"\n" +
                                "}")
        ).andExpect(status().isOk());
        System.out.println("question: " + action.andReturn().getResponse().getContentAsString());
        ResultActions action1 = mockMvc.perform(
                MockMvcRequestBuilders.patch("/question/5")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"questionId\": 5,\n" +
                                "  \"statement\": \"apellido\",\n" +
                                "  \"required\": true,\n" +
                                "  \"type\": \"OPEN\"\n" +
                                "}")
        ).andExpect(status().isOk());
        System.out.println("question: " + action1.andReturn().getResponse().getContentAsString());
    }

    @Test
    void updateDateQuestion() throws Exception {
        ResultActions action = mockMvc.perform(
                MockMvcRequestBuilders.post("/question")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"questionId\": null,\n" +
                                "  \"statement\": \"Fecha actual\",\n" +
                                "  \"required\": true,\n" +
                                "  \"type\": \"DATE\"\n" +
                                "}")
        ).andExpect(status().isOk());
        System.out.println("question: " + action.andReturn().getResponse().getContentAsString());
        ResultActions action1 = mockMvc.perform(
                MockMvcRequestBuilders.patch("/question/5")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"questionId\": null,\n" +
                                "  \"statement\": \"Fecha de ayer\",\n" +
                                "  \"required\": true,\n" +
                                "  \"type\": \"DATE\"\n" +
                                "}")
        ).andExpect(status().isOk());
        System.out.println("question: " + action1.andReturn().getResponse().getContentAsString());
    }

//    @Test
//    void updateMultipleOptionQuestion() throws Exception {
//        ResultActions action = mockMvc.perform(
//                MockMvcRequestBuilders.post("/question")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\n" +
//                                "  \"questionId\": null,\n" +
//                                "  \"statement\": \"SEXO\",\n" +
//                                "  \"required\": true,\n" +
//                                "  \"type\": \"MULTIPLE_OPTION\",\n" +
//                                "  \"answerOptions\": [\n" +
//                                "    \"M\",\n" +
//                                "    \"F\"\n" +
//                                "  ]\n" +
//                                "}")
//        ).andExpect(status().isOk());
//        System.out.println("question: " + action.andReturn().getResponse().getContentAsString());
//        ResultActions action1 = mockMvc.perform(
//                MockMvcRequestBuilders.patch("/question/5")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\n" +
//                                "  \"questionId\": 5,\n" +
//                                "  \"statement\": \"SEXOS\",\n" +
//                                "  \"required\": true,\n" +
//                                "  \"type\": \"MULTIPLE_OPTION\",\n" +
//                                "  \"answerOptions\": [\n" +
//                                "    \"M\",\n" +
//                                "    \"F\",\n" +
//                                "    \"Otro\"\n" +
//                                "  ]\n" +
//                                "}")
//        ).andExpect(status().isOk());
//        System.out.println("question: " + action1.andReturn().getResponse().getContentAsString());
//    }

}
