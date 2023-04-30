package org.javapro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyId;
    @ManyToOne
    SurveyTemplate template;
}
