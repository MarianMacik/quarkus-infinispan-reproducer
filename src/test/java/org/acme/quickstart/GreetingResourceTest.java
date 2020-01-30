package org.acme.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

@QuarkusTest
public class GreetingResourceTest {

    @Inject
    RemoteCacheManager cacheManager;

    @Test
    public void testHelloEndpoint() {
        assertTrue(cacheManager.isStarted());
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello true"));
    }

}