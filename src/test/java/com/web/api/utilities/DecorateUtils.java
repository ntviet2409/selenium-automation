package com.web.api.utilities;

import com.web.api.models.Decorators;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.web.api.constants.GlobalConstants.DECORATE_URL;
import static com.web.api.constants.GlobalConstants.DECORATORS;
import static com.web.api.constants.GlobalConstants.PROD_BASIC_AUTHEN;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

public final class DecorateUtils {

    private DecorateUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static Response createDecorator(Decorators body) {
        return given()
                .contentType(ContentType.JSON)
                .headers(AUTHORIZATION, PROD_BASIC_AUTHEN)
                .body(body)
                .log().all()
                .when()
                .post(DECORATE_URL + DECORATORS);
    }
}
