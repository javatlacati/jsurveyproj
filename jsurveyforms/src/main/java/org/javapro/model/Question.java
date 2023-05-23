package org.javapro.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.javapro.entities.QuestionType;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@ToString
//@JsonDeserialize(using = QuestionDeserializer.class)
//@DiscriminatorColumn(name = "QUESTION_TYPE")
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.DEDUCTION
//        use = JsonTypeInfo.Id.NAME
//        ,include = JsonTypeInfo.As.PROPERTY
//        ,property = "type"
//        , defaultImpl = OpenQuestion.class
//)
//@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type", defaultImpl = OpenQuestion.class)
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
public abstract class Question {
    Long questionId;
    String statement;
    boolean required;
    QuestionType type;
}
