package com.example.javabase.config;

import com.example.javabase.service.TransferService;
import com.example.javabase.service.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.SessionScope;

/**
 * Author saino
 * LastModify 4:56
 */

@Configuration
public class AppConfig {
    @Bean(initMethod = "initFirst")
//    @SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope("singleton")
    public TransferService transferService() {
        return new TransferServiceImpl();
    }

    @Bean(initMethod = "initSecond")
    public TransferService transferServiceSec() {
        return new TransferServiceImpl();
    }
}
