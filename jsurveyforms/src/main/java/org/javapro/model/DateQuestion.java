package org.javapro.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Setter
//@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
//@DiscriminatorValue("Date")
@JsonTypeName("DateQuestion")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
public class DateQuestion extends Question {
    @JsonbDateFormat("MM dd yyyy")
    Date theDate;

    @JsonbProperty("date")
    public Date getTheDate() {
        return theDate;
    }
}
