package org.javapro;

import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.javapro.formtemplate.model.SurveyTemplate;
import org.javapro.survey.model.Survey;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@GraphQLApi
public class HelloGraphQLResource {
    @Inject
    TemplateService templateService;

//    @Inject
//    Vertx vertx;
//
//    private WebClient webClient;

    @PostConstruct
    void initialize(){
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

    public void saveNewSurvey(Survey survey){

    }
}