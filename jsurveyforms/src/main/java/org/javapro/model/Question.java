package org.javapro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.javapro.deserializer.QuestionDeserializer;
import org.javapro.entities.QuestionType;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@ToString
@JsonDeserialize(using = QuestionDeserializer.class)
public class Question implements ATypeOfQuestion {
    Long questionId;
    String statement;
    boolean required;
    QuestionType type;
}
