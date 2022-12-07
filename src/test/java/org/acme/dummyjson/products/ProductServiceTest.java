package org.acme.dummyjson.products;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import org.acme.dummyjson.products.model.ProductList;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@QuarkusTest
class ProductServiceTest {

    @Inject
    @RestClient
    ProductService uut;

    @Test
    void given_whenGetProductList_thenReturnedListHasSize30() {
        // Arrange
        // Act
        Uni<ProductList> actual = uut.getProductList();
        // Assert
        assertThat(actual.await().atMost(Duration.ofSeconds(3)))
                .extracting(ProductList::products)
                .asList().hasSize(30);
    }
}
