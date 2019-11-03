package com.web.enumerations;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public enum EnvironmentType {
    DEV("dev"),
    QA("qa"),
    STAGE("stage"),
    PROD("prod"),
    NONEXISTING("nonexisting");

    @Getter
    private final String name;

    //Lookup table
    private static final Map<String, EnvironmentType> LOOKUP = new HashMap<>();

    EnvironmentType(String envTypeName) {
        this.name = envTypeName;
    }

    //Populate the lookup table on loading time
    static {
        for (EnvironmentType envType : EnvironmentType.values()) {
            LOOKUP.put(envType.getName(), envType);
        }
    }

    public static EnvironmentType get(String typeName) {
        if (LOOKUP.containsKey(typeName)) {
            return LOOKUP.get(typeName);
        } else {
            return null;
        }
    }
}
