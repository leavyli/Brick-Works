package com.example.mall.admin.bo;

import com.example.mall.mbg.model.Admin.Admin;
import com.example.mall.mbg.model.Admin.Resource;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author saino
 * LastModify 16:32
 */
@RequiredArgsConstructor
@Setter
@Getter
public class AdminUserDetails implements UserDetails {
    @NonNull
    private Admin admin;
    @NonNull
    private List<Resource> resources;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return resources.stream().map(resource -> (GrantedAuthority) () -> resource.getUrl()).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return admin.getStatus().equals(1);
    }
}
