package org.acme;

import io.smallrye.mutiny.Uni;

public class ReactiveGreetingResource implements GreetingResourceApi {

    public Uni<String> hello(String nullableFormParam) {
        if(nullableFormParam == null) {
			return Uni.createFrom().item("NULL");
        } else {
	        return Uni.createFrom().item("NONNULL");
        }
    }
}