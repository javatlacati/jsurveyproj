package org.javapro.formtemplate.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.javapro.formtemplate.model.MultipleOptionQuestion;
import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.model.QuestionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionDeserializerTest {

    @Test
    public void testDeserializeOpenQuestion() throws JsonProcessingException {
        // Crea un ObjectMapper para la deserialización
        ObjectMapper objectMapper = new ObjectMapper();

        // Crea el JSON de prueba
        String json = "{\"questionId\": 1, \"statement\": \"¿Esta es una pregunta?\", \"required\": true, \"type\": \"OPEN\"}";

        // Deserializa el JSON en una instancia de Question utilizando el deserializador personalizado
        Question question = objectMapper.readValue(json, Question.class);

        // Verifica que los atributos se hayan deserializado correctamente
        assertEquals(1L, question.getQuestionId());
        assertEquals("¿Esta es una pregunta?", question.getStatement());
        assertTrue(question.isRequired());
        assertEquals(QuestionType.OPEN, question.getType());
    }

    @Test
    public void testDeserializeOpenQuestionWithNullId() throws JsonProcessingException {
        // Crea un ObjectMapper para la deserialización
        ObjectMapper objectMapper = new ObjectMapper();

        // Crea el JSON de prueba
        String json = "{\"questionId\": null, \"statement\": \"¿Esta es una pregunta?\", \"required\": true, \"type\": \"OPEN\"}";

        // Deserializa el JSON en una instancia de Question utilizando el deserializador personalizado
        Question question = objectMapper.readValue(json, Question.class);

        // Verifica que los atributos se hayan deserializado correctamente
        assertNull(question.getQuestionId());
        assertEquals("¿Esta es una pregunta?", question.getStatement());
        assertTrue(question.isRequired());
        assertEquals(QuestionType.OPEN, question.getType());
    }

    @Test
    public void testDeserializeDateQuestion() throws JsonProcessingException {
        // Crea un ObjectMapper para la deserialización
        ObjectMapper objectMapper = new ObjectMapper();

        // Crea el JSON de prueba
        String json = "{\"questionId\": 1, \"statement\": \"¿Esta es una pregunta?\", \"required\": true, \"type\": \"DATE\"}";

        // Deserializa el JSON en una instancia de Question utilizando el deserializador personalizado
        Question question = objectMapper.readValue(json, Question.class);

        // Verifica que los atributos se hayan deserializado correctamente
        assertEquals(1L, question.getQuestionId());
        assertEquals("¿Esta es una pregunta?", question.getStatement());
        assertTrue(question.isRequired());
        assertEquals(QuestionType.DATE, question.getType());
    }

    @Test
    public void testDeserializeMultipleOptionQuestion() throws JsonProcessingException {
        // Crea un ObjectMapper para la deserialización
        ObjectMapper objectMapper = new ObjectMapper();

        // Crea el JSON de prueba
        String json = "{\"questionId\": 2, \"statement\": \"¿Esta es una pregunta de opción múltiple?\", \"required\": false, \"type\": \"MULTIPLE_OPTION\", \"answerOptions\": [\"Opción 1\", \"Opción 2\", \"Opción 3\"]}";

        // Deserializa el JSON en una instancia de MultipleOptionQuestion utilizando el deserializador personalizado
        MultipleOptionQuestion multipleOptionQuestion = objectMapper.readValue(json, MultipleOptionQuestion.class);

        // Verifica que los atributos se hayan deserializado correctamente
        assertEquals(2L, multipleOptionQuestion.getQuestionId());
        assertEquals("¿Esta es una pregunta de opción múltiple?", multipleOptionQuestion.getStatement());
        assertFalse(multipleOptionQuestion.isRequired());
        assertEquals(QuestionType.MULTIPLE_OPTION, multipleOptionQuestion.getType());
        assertEquals(3, multipleOptionQuestion.getAnswerOptions().length);
        assertEquals("Opción 1", multipleOptionQuestion.getAnswerOptions()[0]);
        assertEquals("Opción 2", multipleOptionQuestion.getAnswerOptions()[1]);
        assertEquals("Opción 3", multipleOptionQuestion.getAnswerOptions()[2]);
    }
}
