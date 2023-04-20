package org.javapro;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.javapro.model.SurveyTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * To use it via injection.
 * <p>
 * {@code
 *
 * @Inject
 * @RestClient MyRemoteService myRemoteService;
 * <p>
 * public void doSomething() {
 * Set<MyRemoteService.Extension> restClientExtensions = myRemoteService.getExtensionsById("io.quarkus:quarkus-rest-client");
 * }
 * }
 */
@RegisterRestClient//(baseUri = "http://localhost:8081")
//@ApplicationScoped
//@Default
public interface TemplateService {

    @Path("/template")
    @GET
    SurveyTemplate getTemplateById(@QueryParam("id") String id);

    @Path("/templates")
    @GET
    List<SurveyTemplate> getTemplates();
}
