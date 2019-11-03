package com.web.api.utilities;

import static com.web.api.constants.ApiCommonConstants.KEY;
import static com.web.api.constants.ApiCommonConstants.TOKEN;
import static com.web.api.constants.ApiEndpoints.BOARDS;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public final class BoardsUtils {

    private BoardsUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static Response getBoardInfoById(String baseUrl, String id, String key, String token) {
        return given()
                .contentType(ContentType.JSON)
                .queryParam(KEY, key)
                .queryParam(TOKEN, token)
                .when()
                .get(baseUrl + BOARDS + id + "/");
    }
}
