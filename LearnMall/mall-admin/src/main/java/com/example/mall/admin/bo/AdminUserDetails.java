package com.example.mall.admin.bo;

import com.example.mall.admin.model.Admin;
import com.example.mall.admin.model.Resource;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
//        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return resources.stream().map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName())).collect(Collectors.toList());
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
