package ru.hehmdalolkek.blog.web.controller.util;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class ControllerUtil {

    public String getUsernameFromPrincipal(Principal principal) {
        String username;
        if (principal instanceof OAuth2AuthenticationToken token) {
            OAuth2User oAuth2User = token.getPrincipal();
            String email = oAuth2User.getAttribute("email");
            username = email != null ? email : oAuth2User.getAttribute("login");
        } else {
            username = principal.getName();
        }
        return username;
    }

}
