package org.javapro.formtemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
    Long  questionId;
 String statement;
  boolean required;
}
