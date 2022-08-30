package com.example.mall.security.config;

import com.example.mall.security.component.DynamicSecurityService;
import com.example.mall.security.component.filter.DynamicSecurityFilter;
import com.example.mall.security.component.filter.JwtAuthenticationTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Author saino
 * LastModify 5:37
 */
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final IgnoreUrlsConfig ignoreUrlsConfig;
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    private final DynamicSecurityService dynamicSecurityService;

    private final DynamicSecurityFilter dynamicSecurityFilter;


    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = httpSecurity.authorizeRequests();
        registry.and().httpBasic().disable();
        for (String url : ignoreUrlsConfig.getUrls()) {
            registry.antMatchers(url).permitAll();
        }

        //允许跨域请求的OPTIONS请求
        registry.antMatchers(HttpMethod.OPTIONS).permitAll();

        registry.and()
                .authorizeRequests()
                .antMatchers("/admin/hello").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        registry.and().authorizeRequests().anyRequest().permitAll().and().csrf().disable();

//        if (dynamicSecurityService != null) {
//            registry.and().addFilterBefore(dynamicSecurityFilter, FilterSecurityInterceptor.class);
//        }

        return httpSecurity.build();
    }


}
