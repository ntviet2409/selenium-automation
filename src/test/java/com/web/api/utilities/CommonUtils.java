package com.web.api.utilities;

import com.web.configuration.YmlReaders;
import com.web.enumerations.EnvironmentType;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class CommonUtils {

    private String getBaseUrl(String env) {
        return YmlReaders.getBaseUrl(env);
    }

    public String getAppUrlFromYmlConfig(String ymlAppName, String envType) {
        String url;
        switch (EnvironmentType.get(envType.toLowerCase())) {
            case DEV:
                url = CommonUtils.getBaseUrl(ymlAppName + envType);
                break;
            case PROD:
                url = CommonUtils.getBaseUrl(ymlAppName + envType);
                break;
            case STAGE:
                url = CommonUtils.getBaseUrl(ymlAppName + envType);
                break;
            default:
                url = CommonUtils.getBaseUrl(ymlAppName + envType);
                break;
        }
        return url;
    }
}
