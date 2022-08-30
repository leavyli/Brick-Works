package com.example.mall.security.component.filter;

import com.example.mall.security.component.DynamicAccessDecisionManager;
import com.example.mall.security.component.DynamicSecurityMetadataSource;
import com.example.mall.security.config.IgnoreUrlsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Author saino
 * LastModify 5:46
 */
@RequiredArgsConstructor
public class DynamicSecurityFilter extends AbstractSecurityInterceptor implements Filter {
    private final IgnoreUrlsConfig ignoreUrlsConfig;
    private final DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    private final AccessDecisionManager  accessDecisionManager;

    @PostConstruct
    public void setDynamicAccessDecisionManager() {
        super.setAccessDecisionManager(accessDecisionManager);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        FilterInvocation fi = new FilterInvocation(servletRequest, servletResponse, chain);

        //Option的请求直接放行
        if (request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
            return;
        }

        PathMatcher pathMatcher = new AntPathMatcher();

        // 白名单放行
        for (var url : ignoreUrlsConfig.getUrls()) {
            if (pathMatcher.match(url, request.getRequestURI())) {
                fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
                return;
            }
        }

        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return dynamicSecurityMetadataSource;
    }
}
