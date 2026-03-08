package com.automation.apiTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.api.APIBase;

public class GetUsersAPITest {

    @BeforeClass
    public void setup() {
        APIBase.setup();
    }

    @Test
    public void getUsersTest() {

        given()
            .log().all()

        .when()
            .get("/users")

        .then()
            .log().all()
            .statusCode(200)
            .body("[0].id", equalTo(1));
    }
}