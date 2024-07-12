package ru.hehmdalolkek.blog.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.hehmdalolkek.blog.dao.UserDao;
import ru.hehmdalolkek.blog.model.Role;
import ru.hehmdalolkek.blog.model.User;

import java.io.IOException;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    private final UserDao userDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (authentication.getPrincipal() instanceof OAuth2AuthenticationToken token) {
            OAuth2User oAuth2User = token.getPrincipal();
            String email = oAuth2User.getAttribute("email");
            String username = email != null ? email : oAuth2User.getAttribute("login");
            if (!this.userDao.existsByUsername(username)) {
                User user = User.builder()
                        .username(username)
                        .password("oAuth_password")
                        .roles(Set.of(Role.AUTHOR))
                        .build();
                this.userDao.save(user);
            }
        }
        new DefaultRedirectStrategy().sendRedirect(request, response, "/posts");
    }

}
