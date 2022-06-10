package com.example.javadesignpattern.facePattern.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Author saino
 * LastModify 17:13
 */
@ConfigurationProperties(prefix = "facetodo.door")
public class StarterServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
