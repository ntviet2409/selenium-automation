package com.web.api.constants;

import org.apache.commons.lang3.RandomStringUtils;

public final class ApiCommonConstants {
    public static final String KEY = "key";
    public static final String TOKEN = "token";
    public static final String PRODUCTION = "prod";

    public static final String NON_EXISTING_TOKEN = "non-existing" + RandomStringUtils.random(10);
    public static final String DECORATE_URL = "http://decoration-rest-server.codegraph-prod.devfactory.com/api/v1.0";
    public static final String PROD_BASIC_AUTHEN = "Basic YWRtaW46bWl6emxy";
    public static final String DECORATORS = "/decorators/";
    public static final String TRELLO = "trello.";

    private ApiCommonConstants() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }
}
