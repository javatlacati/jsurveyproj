package org.javapro.formtemplate.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotNull;
import org.javapro.formtemplate.deserializer.QuestionDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@ToString
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "type")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = MultipleOptionQuestion.class, name = "MULTIPLE_OPTION"),
//        @JsonSubTypes.Type(value = Question.class, name = "OPEN"),
//        @JsonSubTypes.Type(value = Question.class, name = "DATE")
//})
@JsonDeserialize(using = QuestionDeserializer.class)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long questionId;
    @NotNull(message = "la pregunta no puede ir sin enunciado")
    String statement;
    boolean required;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "la pregunta no puede ir sin su tipo")
    QuestionType type;
}
