package org.javapro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
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
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property="type", defaultImpl = OpenQuestion.class)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DateQuestion.class
                , name = "DateQuestion"
        ),
        @JsonSubTypes.Type(value = MultipleOptionQuestion.class
                , name = "MultipleOptionQuestion"
        ),
        @JsonSubTypes.Type(value = OpenQuestion.class
                , name = "OpenQuestion"
        )
})
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long questionId;
    String statement;
    boolean required;
}
