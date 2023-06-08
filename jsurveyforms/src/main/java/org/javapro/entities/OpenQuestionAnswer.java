package org.javapro.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.Entity;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
//@DiscriminatorValue("Open")
//@JsonTypeName("OpenQuestion")
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.EXISTING_PROPERTY,
//        property = "type"
//)
public class OpenQuestionAnswer extends Answer {
    @Builder.Default
    String answer = "";

    public OpenQuestionAnswer() {
        super();
    }
}
