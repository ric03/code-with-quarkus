package org.acme.dummyjson.products;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import org.acme.dummyjson.auth.AuthTokenService;
import org.acme.dummyjson.auth.model.LoginCredentials;
import org.acme.dummyjson.products.model.ProductList;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@QuarkusTest
class ProtectedProductServiceTest {

    private static final LoginCredentials LOGIN_CREDENTIALS = new LoginCredentials("atuny0", "9uQFF1Lh");

    @Inject
    @RestClient
    ProtectedProductService uut;

    @Inject
    @RestClient
    AuthTokenService authTokenService;

    @Test
    void given_when_then() {
        // Arrange
        var loginResult = authTokenService.login(LOGIN_CREDENTIALS)
                .await().atMost(Duration.ofSeconds(3));
        // Act
        Uni<ProductList> actualUni = uut.getProductList("Bearer " + loginResult.token());
        // Assert
        ProductList actual = actualUni.await().atMost(Duration.ofSeconds(3));
        assertThat(actual).extracting(ProductList::products)
                .asList()
                .hasSize(30);
    }


    @Test
    void given_when_then1() {
        // Arrange
        // Act
        Uni<ProductList> actualUni = uut.getProductList();
        // Assert
        ProductList actual = actualUni.await().atMost(Duration.ofSeconds(3));
        assertThat(actual).extracting(ProductList::products)
                .asList()
                .hasSize(30);
    }
}
