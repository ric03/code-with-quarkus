package org.acme;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @TestHTTPResource("/hello")
    URL url;

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get(url.getPath() + "/")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    void testGreetingEndpoint() {
        given()
                .pathParam("name", "turtle").
                when()
                .get(url.getPath() + "/greeting/{name}").
                then()
                .statusCode(200)
                .body(is("hello turtle"));
    }
}