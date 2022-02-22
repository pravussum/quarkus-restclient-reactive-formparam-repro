package org.acme;

import io.smallrye.mutiny.Uni;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "testClient")
@Path("/hello")
public interface GreetingResourceApi {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	Uni<String> hello(@FormParam("formParam") String nullableFormParam);
}
