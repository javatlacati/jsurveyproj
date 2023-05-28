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
@DirtiesContext
class SectionControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getSections() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/sections")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        System.out.println("sections: " + action.andReturn().getResponse().getContentAsString());
    }

    @Test
    void findById() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.get("/section/1")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        System.out.println("section: " + action.andReturn().getResponse().getContentAsString());
    }


    @Test
    void deleteById() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("/section")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"sectionId\": null,\n" +
                                "  \"name\": \"datos generales\",\n" +
                                "  \"questions\": [\n" +
                                "    {\n" +
                                "      \"questionId\": null,\n" +
                                "      \"statement\": \"nombre\",\n" +
                                "      \"required\": true,\n" +
                                "      \"type\": \"OPEN\"\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}")
                )
                .andExpect(status().isOk());
        System.out.println("section: " + action.andReturn().getResponse().getContentAsString());
        ResultActions action1 = mockMvc.perform(MockMvcRequestBuilders.delete("/section/3")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"sectionId\": null,\n" +
                                "  \"name\": \"datos generales\",\n" +
                                "  \"questions\": [\n" +
                                "    {\n" +
                                "      \"questionId\": null,\n" +
                                "      \"statement\": \"nombre\",\n" +
                                "      \"required\": true,\n" +
                                "      \"type\": \"OPEN\"\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}")
                )
                .andExpect(status().isOk());
        ResultActions action2 = mockMvc.perform(MockMvcRequestBuilders.get("/section/3")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        System.out.println("section: " + action2.andReturn().getResponse().getContentAsString());
    }

    @Test
    void createSection() throws Exception {
        ResultActions action = mockMvc.perform(MockMvcRequestBuilders.post("/section")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"sectionId\": null,\n" +
                                "  \"name\": \"datos generales\",\n" +
                                "  \"questions\": [\n" +
                                "    {\n" +
                                "      \"questionId\": null,\n" +
                                "      \"statement\": \"nombre\",\n" +
                                "      \"required\": true,\n" +
                                "      \"type\": \"OPEN\"\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}")
                )
                .andExpect(status().isOk());
        System.out.println("section: " + action.andReturn().getResponse().getContentAsString());
    }

    @Test
    void update() {
    }
}
