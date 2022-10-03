package org.acme.hibernate.orm.panache;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
class FruitResourceTest {

    @Test
    void givenData_whenGetAllFruits_then() {
        given().
                when()
                .get("/fruits").
                then()
                .statusCode(200)
                .body(containsString("Banana"));
    }
}