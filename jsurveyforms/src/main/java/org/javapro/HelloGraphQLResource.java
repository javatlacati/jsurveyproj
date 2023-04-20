package org.javapro;

import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.rest.client.inject.RestClient;
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

    public void saveNewSurvey(Survey survey) {

    }
}