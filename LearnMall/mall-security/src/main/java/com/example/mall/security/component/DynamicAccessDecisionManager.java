package com.example.mall.security.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * Author saino
 * LastModify 10:09
 */
public class DynamicAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null | configAttributes.isEmpty()) {
            return ;
        }
        Iterator<ConfigAttribute> iterator =  configAttributes.iterator();

        while(iterator.hasNext()) {
            ConfigAttribute configAttribute =  iterator.next();

            String needAuthority = configAttribute.getAttribute();
            for (GrantedAuthority grantedAuthority: authentication.getAuthorities()) {
                if (needAuthority.trim().equals(grantedAuthority)) {
                    return;
                }
            }

        }

        throw new AccessDeniedException("sorry, no access right");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
