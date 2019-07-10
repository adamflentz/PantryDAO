package com.adamlentz.pantryDao.security;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class UserPrincipal {

    private Long id;
    private String email;
    private String password;
    private List<Map<AuthorityKeys, AuthType>> authorities;
    private Map<String, Object> attributes;

    public UserPrincipal(Long id, String email, String password, List<Map<AuthorityKeys, AuthType>> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUsername() {
        return email;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
