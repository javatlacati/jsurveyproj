package org.javapro;

import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.javapro.model.DateQuestion;
import org.javapro.model.OpenQuestion;
import org.javapro.model.Question;
import org.javapro.model.Survey;
import org.javapro.model.SurveyTemplate;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class HelloGraphQLResource {
    @Inject
    @RestClient
//    @Default
    TemplateService templateService;

//    @Inject
//    Vertx vertx;
//
//    private WebClient webClient;

    @PostConstruct
    void initialize() {
//        this.webClient.create(vertx, new WebClientOptions().setDefaultHost("localhost").setDefaultPort(8081).setSsl(false).setTrustAll(true));
    }

    @Query
    @Description("Say hello")
    public String sayHello(@DefaultValue("World") String name) {
        return "Hello " + name;
    }

    @Query
    @Description("Retrieves a template")
    public SurveyTemplate getTemplate(Long id) {
        return templateService.getTemplateById(Long.toString(id));
    }

    @Query
    @Description("Retrieves all templates")
    public List<SurveyTemplate> getTemplates() {
        return templateService.getTemplates();
    }

    @Query
    public boolean isDateQuestion(@Source Question question) {
        return question instanceof DateQuestion;
    }
    @Query
    public boolean isOpenQuestion(@Source Question question) {
        return question instanceof OpenQuestion;
    }

    @Query
    public DateQuestion getDateQuestion(@Source Question question) {
        if(isDateQuestion(question)){
            return (DateQuestion) question;
        }
        return null;
    }

    @Query
    public OpenQuestion getOpenQuestion(@Source Question question) {
        if(isOpenQuestion(question)){
            return (OpenQuestion) question;
        }
        return null;
    }

    public void saveNewSurvey(Survey survey) {

    }
}