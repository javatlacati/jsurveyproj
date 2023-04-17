package org.javapro.survey.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.javapro.formtemplate.model.SurveyTemplate;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    @Id
    private Long surveyId;
    @ManyToOne
    SurveyTemplate template;
}
