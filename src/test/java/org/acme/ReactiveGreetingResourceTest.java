package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@QuarkusTest
public class ReactiveGreetingResourceTest {

	@Inject
	@RestClient
	GreetingResourceApi reactiveGreetingResourceClient;

    @Test
    public void testHelloEndpoint() {
	    var subscriber = reactiveGreetingResourceClient.hello("testparam")
			    .subscribe()
			    .withSubscriber(UniAssertSubscriber.create());
	    subscriber
			    .awaitItem()
			    .assertCompleted().assertItem("NONNULL");
    }

    @Test
    public void testHelloEndpointNullParam() {
	    var subscriber = reactiveGreetingResourceClient.hello(null)
			    .subscribe()
			    .withSubscriber(UniAssertSubscriber.create());
	    subscriber
			    .awaitItem()
			    .assertCompleted().assertItem("NULL");
    }

}