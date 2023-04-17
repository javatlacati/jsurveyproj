package org.javapro;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.javapro.survey.model.Survey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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
@RegisterRestClient(baseUri = "http://localhost:8080")
public interface MyRemoteService {

    @GET
    @Path("/template")
    Survey getTemplateById(@QueryParam("id") String id);
}
