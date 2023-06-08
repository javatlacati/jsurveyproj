package org.javapro.formtemplate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class SurveyTemplate   implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyTemplateId;
    private String uuid;
    @OneToMany
    private List<Section> sections;
}
