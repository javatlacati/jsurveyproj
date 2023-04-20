package org.javapro.formtemplate.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
@JsonTypeName("OpenQuestion")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
public class OpenQuestion extends Question {
    @Builder.Default
    String answer = "";

    public OpenQuestion() {
        super();
    }
}
