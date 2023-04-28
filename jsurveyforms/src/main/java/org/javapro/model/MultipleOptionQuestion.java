package org.javapro.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.graphql.Description;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
//@DiscriminatorValue("MultipleOption")
@JsonTypeName("MultipleOptionQuestion")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
public class MultipleOptionQuestion extends Question {
    @Description("Answer options")
    String[] answerOptions;
    @Description("zeroth-based index of the correct answer")
    int answerIdx;

}
