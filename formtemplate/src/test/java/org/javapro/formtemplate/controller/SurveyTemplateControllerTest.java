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

    @Test
    void update() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("/template")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "    \"surveyTemplateId\": null,\n" +
                                 "    \"sections\": [\n" +
                                 "        {\n" +
                                 "            \"sectionId\": null,\n" +
                                 "            \"name\": \"datos generales\",\n" +
                                 "            \"questions\": [\n" +
                                 "                {\n" +
                                 "                        \"questionId\": null,\n" +
                                 "                        \"statement\": \"nombre\",\n" +
                                 "                        \"required\": true,\n" +
                                 "                        \"type\": \"OPEN\"\n" +
                                 "                }\n" +
                                 "            ]\n" +
                                 "        }\n" +
                                 "    ]\n" +
                                 "}")
                )
                .andExpect(status().isOk());
        System.out.println("templates: " + action.andReturn().getResponse().getContentAsString());
        ResultActions action1 = mockMvc.perform(MockMvcRequestBuilders.patch("/template/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "    \"surveyTemplateId\": 2,\n" +
                                 "    \"sections\": [\n" +
                                 "        {\n" +
                                 "            \"sectionId\": null,\n" +
                                 "            \"name\": \"datos generales\",\n" +
                                 "            \"questions\": [\n" +
                                 "                {\n" +
                                 "                        \"questionId\": null,\n" +
                                 "                        \"statement\": \"apellido\",\n" +
                                 "                        \"required\": true,\n" +
                                 "                        \"type\": \"OPEN\"\n" +
                                 "                }\n" +
                                 "            ]\n" +
                                 "        }\n" +
                                 "    ]\n" +
                                 "}")
                )
                .andExpect(status().isOk());
        System.out.println("templates: " + action1.andReturn().getResponse().getContentAsString());
    }

    @Test
    void updateWithMultipleQuestions() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("/template")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "    \"surveyTemplateId\": null,\n" +
                                 "    \"sections\": [\n" +
                                 "        {\n" +
                                 "            \"sectionId\": null,\n" +
                                 "            \"name\": \"datos generales\",\n" +
                                 "            \"questions\": [\n" +
                                 "                {\n" +
                                 "                        \"questionId\": null,\n" +
                                 "                        \"statement\": \"nombre\",\n" +
                                 "                        \"required\": true,\n" +
                                 "                        \"type\": \"OPEN\"\n" +
                                 "                }\n" +
                                 "            ]\n" +
                                 "        }\n" +
                                 "    ]\n" +
                                 "}")
                )
                .andExpect(status().isOk());
        System.out.println("templates: " + action.andReturn().getResponse().getContentAsString());
        ResultActions action1 = mockMvc.perform(MockMvcRequestBuilders.patch("/template/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "surveyTemplateId": 2,
                                  "sections": [
                                    {
                                      "sectionId": null,
                                      "name": "datos generales",
                                      "questions": [
                                        {
                                          "questionId": null,
                                          "statement": "apellido",
                                          "required": true,
                                          "type": "OPEN"
                                        },
                                        {
                                          "questionId": null,
                                          "statement": "SEXO",
                                          "required": true,
                                          "type": "MULTIPLE_OPTION",
                                          "answerOptions": [
                                            "M",
                                            "F"
                                          ]
                                        }
                                      ]
                                    }
                                  ]
                                }""")
                )
                .andExpect(status().isOk());
        System.out.println("templates: " + action1.andReturn().getResponse().getContentAsString());
    }

    @Test
    void deleteById() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("/template")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "    \"surveyTemplateId\": null,\n" +
                                 "    \"sections\": [\n" +
                                 "        {\n" +
                                 "            \"sectionId\": null,\n" +
                                 "            \"name\": \"datos generales\",\n" +
                                 "            \"questions\": [\n" +
                                 "                {\n" +
                                 "                        \"questionId\": null,\n" +
                                 "                        \"statement\": \"nombre\",\n" +
                                 "                        \"required\": true,\n" +
                                 "                        \"type\": \"OPEN\"\n" +
                                 "                }\n" +
                                 "            ]\n" +
                                 "        }\n" +
                                 "    ]\n" +
                                 "}")
                )
                .andExpect(status().isOk());
        System.out.println("templates: " + action.andReturn().getResponse().getContentAsString());
        ResultActions action1 = mockMvc.perform(MockMvcRequestBuilders.delete("/template/2")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "    \"surveyTemplateId\": 2,\n" +
                                 "    \"sections\": [\n" +
                                 "        {\n" +
                                 "            \"sectionId\": null,\n" +
                                 "            \"name\": \"datos generales\",\n" +
                                 "            \"questions\": [\n" +
                                 "                {\n" +
                                 "                        \"questionId\": null,\n" +
                                 "                        \"statement\": \"nombre\",\n" +
                                 "                        \"required\": true,\n" +
                                 "                        \"type\": \"OPEN\"\n" +
                                 "                }\n" +
                                 "            ]\n" +
                                 "        }\n" +
                                 "    ]\n" +
                                 "}")
                )
                .andExpect(status().isOk());
        ResultActions action2 = mockMvc.perform(MockMvcRequestBuilders.get("/template/2")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "    \"surveyTemplateId\": 2,\n" +
                                 "    \"sections\": [\n" +
                                 "        {\n" +
                                 "            \"sectionId\": null,\n" +
                                 "            \"name\": \"datos generales\",\n" +
                                 "            \"questions\": [\n" +
                                 "                {\n" +
                                 "                        \"questionId\": null,\n" +
                                 "                        \"statement\": \"nombre\",\n" +
                                 "                        \"required\": true,\n" +
                                 "                        \"type\": \"OPEN\"\n" +
                                 "                }\n" +
                                 "            ]\n" +
                                 "        }\n" +
                                 "    ]\n" +
                                 "}")
                )
                .andExpect(status().isOk());
        System.out.println("templates: " + action2.andReturn().getResponse().getContentAsString());
    }

    @Test
    void createTemplate() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("/template")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "    \"surveyTemplateId\": null,\n" +
                                 "    \"sections\": [\n" +
                                 "        {\n" +
                                 "            \"sectionId\": null,\n" +
                                 "            \"name\": \"datos generales\",\n" +
                                 "            \"questions\": [\n" +
                                 "                {\n" +
                                 "                        \"questionId\": null,\n" +
                                 "                        \"statement\": \"nombre\",\n" +
                                 "                        \"required\": true,\n" +
                                 "                        \"type\": \"OPEN\"\n" +
                                 "                }\n" +
                                 "            ]\n" +
                                 "        }\n" +
                                 "    ]\n" +
                                 "}")
                )
                .andExpect(status().isOk());
        System.out.println("templates: " + action.andReturn().getResponse().getContentAsString());
    }
}
