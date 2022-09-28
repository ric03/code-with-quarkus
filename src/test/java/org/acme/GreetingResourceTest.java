package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    void testGreetingEndpoint() {
        given()
                .pathParam("name", "turtle").
                when()
                .get("/greeting/{name}").
                then()
                .statusCode(200)
                .body(is("hello turtle"));
    }
}