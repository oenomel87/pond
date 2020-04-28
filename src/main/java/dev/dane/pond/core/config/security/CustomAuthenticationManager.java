package dev.dane.pond.core.config.security;

import dev.dane.pond.user.domain.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    private final UserService userService;

    public CustomAuthenticationManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        var username = authentication.getName();
        var password = authentication.getCredentials().toString();
        var user = this.userService.fetchUser(username);
        if(user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password);
        }
        return null;
    }
}
