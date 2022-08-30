package com.example.mall.security.component;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.util.UrlPathHelper;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 动态数据源
 * Author saino
 * LastModify 14:42
 */
@RequiredArgsConstructor
public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private final DynamicSecurityService dynamicSecurityService;
    private static Map<String, ConfigAttribute> configAttributeMap = null;

    private static UrlPathHelper urlPathHelper = new UrlPathHelper();

    @PostConstruct
    public void loadDataSource() {
        configAttributeMap  =  dynamicSecurityService.loadDataSource();
    }

    public void clearDataSource() {
        configAttributeMap.clear();
        configAttributeMap = null;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (configAttributeMap == null) {
            this.loadDataSource();
        }
        List<ConfigAttribute> configAttributes = new ArrayList<>();

//        String url = ((FilterInvocation) object).getRequestUrl();
        String path = urlPathHelper.getServletPath(
                ((FilterInvocation)object).getRequest()
        );

        PathMatcher pathMatcher = new AntPathMatcher();
        Iterator<String> iterator = configAttributeMap.keySet().iterator();

        while (iterator.hasNext()) {
            String pattern = iterator.next();
            if (pathMatcher.match(pattern, path)) {
                configAttributes.add(configAttributeMap.get(pattern));
            }
        }


        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
