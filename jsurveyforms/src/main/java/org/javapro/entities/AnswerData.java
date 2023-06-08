package org.javapro.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class AnswerData {
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate theDate; // Para DateAnswer
    private Integer answerIdx; // Para MultipleOptionAnswer
    private String answer; // Para OpenQuestionAnswer
}
