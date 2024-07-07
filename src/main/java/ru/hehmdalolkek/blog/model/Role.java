package ru.hehmdalolkek.blog.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    AUTHOR, ADMIN;

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
