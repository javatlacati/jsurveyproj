package org.javapro;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.javapro.model.SurveyTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    @Path("/template/uuid/{uuid}")
    @GET
    SurveyTemplate getTemplateByUUid(@PathParam("uuid") String uuid);

    @Path("/templates")
    @GET
    List<SurveyTemplate> getTemplates();
}
