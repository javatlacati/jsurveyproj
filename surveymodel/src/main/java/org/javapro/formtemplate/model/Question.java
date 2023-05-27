package org.javapro.formtemplate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotNull;
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
//@DiscriminatorColumn(name="QUESTION_TYPE")
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", defaultImpl = OpenQuestion.class)
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = DateQuestion.class
//                , name = "DateQuestion"
//        ),
//        @JsonSubTypes.Type(value = MultipleOptionQuestion.class
//                , name = "MultipleOptionQuestion"
//        ),
//        @JsonSubTypes.Type(value = OpenQuestion.class
//                , name = "OpenQuestion"
//        )
//})
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
