package com.automation.api;

import io.restassured.RestAssured;

public class APIBase {

    public static void setup() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    }
}