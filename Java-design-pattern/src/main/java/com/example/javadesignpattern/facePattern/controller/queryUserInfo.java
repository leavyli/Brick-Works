package com.example.javadesignpattern.facePattern.controller;

import com.example.javadesignpattern.facePattern.config.StarterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author saino
 * LastModify 17:46
 */
@RestController
@Slf4j
public class queryUserInfo {
    private final StarterService starterService;

    public queryUserInfo(StarterService starterService) {
        this.starterService = starterService;
    }


    @GetMapping("/queryUserInfo")
    public void queryUserInfo() {
        var userStr= starterService.getUserStr();
        log.info("userStr: {}", userStr);
    }

}
