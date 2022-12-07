package org.acme.dummyjson.products;

import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import org.acme.dummyjson.auth.AuthTokenService;
import org.acme.dummyjson.auth.model.LoginCredentials;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientRequestContext;

import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import java.time.Duration;

public class TokenProvider extends OidcClientRequestReactiveFilter {

    private static final LoginCredentials LOGIN_CREDENTIALS = new LoginCredentials("atuny0", "9uQFF1Lh");

    @Inject
    @RestClient
    AuthTokenService authTokenService;

    @Override
    public void filter(ResteasyReactiveClientRequestContext requestContext) {
        String token = authTokenService.login(LOGIN_CREDENTIALS).await().atMost(Duration.ofSeconds(3)).token();
        requestContext.getHeaders().putSingle(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }
}
