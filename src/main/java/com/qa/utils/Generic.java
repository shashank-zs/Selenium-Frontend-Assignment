package com.qa.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class Generic {
    public static Response postApiCall( String payload, String url) {
        Response response = RestAssured.given()
                .body(payload)
                .when()
                .post(url);
   //    Assert.assertEquals(expectedStatusCode, response.getStatusCode());
        return response;
    }
}
