package org.javapro;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.javapro.model.SurveyTemplate;

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

    @Path("/template/uuid/{uuid}")
    @GET
    SurveyTemplate getTemplateByUUid(@PathParam("uuid") String uuid);

    @Path("/templates")
    @GET
    List<SurveyTemplate> getTemplates();
}
