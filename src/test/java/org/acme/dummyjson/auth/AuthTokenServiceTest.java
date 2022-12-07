package org.acme.dummyjson.auth;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import org.acme.dummyjson.auth.model.LoginCredentials;
import org.acme.dummyjson.auth.model.LoginResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class AuthTokenServiceTest {

    @Inject
    @RestClient
    AuthTokenService uut;

    @Test
    void givenLoginCredentials_whenLogin_thenLoginResultContainsToken() {
        // Arrange
        final var LOGIN_CREDENTIALS = new LoginCredentials("atuny0", "9uQFF1Lh");
        // Act
        Uni<LoginResult> actual = uut.login(LOGIN_CREDENTIALS);
        // Assert
        final var expectedToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZz9zaXplPTUweDUwJnNldD1zZXQxIiwiaWF0IjoxNjM1NzczOTYyLCJleHAiOjE2MzU3Nzc1NjJ9.n9PQX8w8ocKo0dMCw3g8bKhjB8Wo7f7IONFBDqfxKhs";
        assertThat(actual.await().atMost(Duration.ofSeconds(3))).extracting(LoginResult::token).isEqualTo(expectedToken);
    }
}
