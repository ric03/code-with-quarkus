package org.acme.dummyjson.auth;

import io.smallrye.mutiny.Uni;
import org.acme.dummyjson.auth.model.LoginCredentials;
import org.acme.dummyjson.auth.model.LoginResult;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/auth/login")
@RegisterRestClient(configKey = "dummy-json-api")
public interface AuthTokenService {

    @POST
    Uni<LoginResult> login(LoginCredentials loginCredentials);
}
