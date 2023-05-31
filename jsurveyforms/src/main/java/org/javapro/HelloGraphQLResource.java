package org.javapro;

import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.javapro.entities.Survey;
import org.javapro.model.MultipleOptionQuestion;
import org.javapro.model.Question;
import org.javapro.model.SurveyTemplate;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class HelloGraphQLResource {
    @Inject
    @RestClient
    TemplateService templateService;

    @PostConstruct
    void initialize() {
    }

    @Query
    @Description("Say hello")
    public String sayHello(@DefaultValue("World") String name) {
        return "Hello " + name;
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

//    @Query
//    public boolean isMultipleOptionQuestion(@Source Question question) {
//        return question instanceof MultipleOptionQuestion;
//    }
//
//    @Query
//    public MultipleOptionQuestion getMultipleOptionQuestion(@Source Question question) {
//        if (isMultipleOptionQuestion(question)) {
//            return (MultipleOptionQuestion) question;
//        }
//        return null;
//    }


    public void saveNewSurvey(Survey survey) {

    }
}
