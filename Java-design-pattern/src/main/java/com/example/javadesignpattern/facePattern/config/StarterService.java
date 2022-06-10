package com.example.javadesignpattern.facePattern.config;

/**
 * Author saino
 * LastModify 17:12
 */
public class StarterService {
    private String userStr;

    public StarterService() {
    }
    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }


    public String[] split(String separatorChar) {
        return this.userStr.split(separatorChar);
    }

}
