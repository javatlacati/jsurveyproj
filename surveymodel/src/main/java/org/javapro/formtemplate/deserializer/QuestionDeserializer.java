package org.javapro.formtemplate.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.javapro.formtemplate.model.MultipleOptionQuestion;
import org.javapro.formtemplate.model.Question;
import org.javapro.formtemplate.model.QuestionType;

import java.io.IOException;

public class QuestionDeserializer extends JsonDeserializer<Question> {
    @Override
    public Question deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        // Obtén el árbol JSON raíz
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode rootNode = codec.readTree(jsonParser);

        // Obtén el valor de la propiedad "type" para determinar el tipo de entidad
        JsonNode typeNode = rootNode.get("type");
        if (typeNode == null || !typeNode.isTextual()) {
            throw new IllegalArgumentException("No se encontró la propiedad 'type' o no es un valor textual.");
        }

        String type = typeNode.asText();
        Question question;
        if ("MULTIPLE_OPTION".equals(type)) {
            question = new MultipleOptionQuestion();
        } else {
            question = new Question();
        }

        JsonNode questionIdNode = rootNode.get("questionId");
        Long questionId = questionIdNode.isNull() ? null : questionIdNode.longValue();
        question.setQuestionId(questionId);

        JsonNode statementNode = rootNode.get("statement");
        if (statementNode != null && statementNode.isTextual()) {
            question.setStatement(statementNode.asText());
        }

        JsonNode requiredNode = rootNode.get("required");
        if (requiredNode != null && requiredNode.isBoolean()) {
            question.setRequired(requiredNode.asBoolean());
        }

        JsonNode typeEnumNode = rootNode.get("type");
        if (typeEnumNode != null && typeEnumNode.isTextual()) {
            String typeEnumValue = typeEnumNode.asText();
            QuestionType questionType = QuestionType.valueOf(typeEnumValue);
            question.setType(questionType);
        }

        if (question instanceof MultipleOptionQuestion) {
            MultipleOptionQuestion multipleOptionQuestion = (MultipleOptionQuestion) question;

            JsonNode answerOptionsNode = rootNode.get("answerOptions");
            if (answerOptionsNode != null && answerOptionsNode.isArray()) {
                ArrayNode answerOptionsArrayNode = (ArrayNode) answerOptionsNode;
                String[] answerOptions = new String[answerOptionsArrayNode.size()];
                for (int i = 0; i < answerOptionsArrayNode.size(); i++) {
                    JsonNode answerOptionNode = answerOptionsArrayNode.get(i);
                    if (answerOptionNode != null && answerOptionNode.isTextual()) {
                        answerOptions[i] = answerOptionNode.asText();
                    }
                }
                multipleOptionQuestion.setAnswerOptions(answerOptions);
            }
        }

        return question;
    }
}
