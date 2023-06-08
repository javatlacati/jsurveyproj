package org.javapro.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//import org.javapro.model.SurveyTemplate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyId;
    //    @ManyToOne
//    SurveyTemplate template
    private Long templateId;
    @OneToMany
    private List<Answer> answers;
}
