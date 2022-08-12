package com.example.mall.common.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

/**
 * Author saino
 * LastModify 9:45
 * Swagger的基础配置，其他模块再此基础继承扩展
 */
public abstract class BaseSwaggerConfig {

//    @Bean
//    public GroupedOpenApi createRestApi() {
//        SwaggerProperties swaggerProperties = swaggerProperties();
//        GroupedOpenApi docket = GroupedOpenApi.builder()
//                .apiInfo(apiInfo(swaggerProperties))
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getApiBasePackage()))
//                .paths(PathSelectors.any())
//                .build();
//        if (swaggerProperties.isEnableSecurity()) {
//            docket.securitySchemes(securitySchemes()).securityContexts(securityContexts());
//        }
//        return docket;
//    }

    @Bean
    public GroupedOpenApi createRestApi() {
        return GroupedOpenApi.builder()
                .group("mall-admin")
//                .pathsToMatch("/admin/**")
//                .addOpenApiMethodFilter(method -> method.isAnnotationPresent(Admin.class))
                .build();
    }


}
