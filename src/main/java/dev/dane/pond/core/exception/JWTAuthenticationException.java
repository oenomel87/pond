package dev.dane.pond.core.exception;

import org.springframework.security.core.AuthenticationException;

public class JWTAuthenticationException extends AuthenticationException {
    private static final long serialVersionUID = 740938851018636351L;

    public JWTAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JWTAuthenticationException(String msg) {
        super(msg);
    }
}
