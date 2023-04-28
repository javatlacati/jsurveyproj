package org.javapro.model;

//import io.smallrye.graphql.api.annotations.GraphQLName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
//@DiscriminatorValue("Open")
//@GraphQLName("OpenQuestion")
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
