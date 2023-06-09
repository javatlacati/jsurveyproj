package org.javapro;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.javapro.entities.Answer;
import org.javapro.entities.Survey;
import org.javapro.model.SurveyTemplate;
import org.javapro.repository.AnswerRepository;
import org.javapro.repository.SurveyRepository;

import java.util.List;

@GraphQLApi
public class HelloGraphQLResource {
    @Inject
    @RestClient
    TemplateService templateService;

    @Inject
    SurveyRepository surveyRepository;

    @Inject
    AnswerRepository answerRepository;

    @PostConstruct
    void initialize() {
    }

    @Query
    @Description("Retrieves a template")
    public SurveyTemplate getTemplate(String uuid) {
        return templateService.getTemplateByUUid(uuid);
    }

    @Query
    @Description("Retrieves all templates")
    public List<SurveyTemplate> getTemplates() {
        return templateService.getTemplates();
    }

    @Query
    @Description("retrieves al answered surveys")
    public List<Survey> getSurveys() {
        return surveyRepository.findAll();
    }


    @Mutation
    @Description("saves survey responses")
    public Survey saveNewSurvey(Survey survey) {
        List<Answer> answers = survey.getAnswers();
        if (answers != null && !answers.isEmpty()) {
            for (int i = 0; i < answers.size(); i++) {
                var answer = answers.get(i);
                if (answer.getId() == null) {
                    answers.set(i, answerRepository.save(answer));
                }
            }
        }
        return this.surveyRepository.save(survey);
    }
}
