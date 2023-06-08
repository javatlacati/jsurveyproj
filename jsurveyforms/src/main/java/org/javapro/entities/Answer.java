package org.javapro.entities;

//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
//import org.javapro.deserializer.AnswerDeserializer;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@ToString
//@JsonDeserialize(using = AnswerDeserializer.class)
@EqualsAndHashCode
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long questionId;
    QuestionType questionType;
    @Embedded
    private AnswerData answerData;
}
