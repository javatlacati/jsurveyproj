package org.javapro.formtemplate.model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
//@DiscriminatorValue("Open")
public class OpenQuestion extends Question {
    @Builder.Default
    String answer = "";

    public OpenQuestion() {
        super();
    }
}
