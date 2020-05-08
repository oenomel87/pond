package dev.dane.pond.core.config.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(JWTConstants.AUTH_PATH);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        var username = request.getParameter("username");
        var password = request.getParameter("password");
        var authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return this.authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication) {
        String username = (String) authentication.getPrincipal();
        var signingKey = JWTConstants.JWT_SECRET.getBytes();
        var token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", JWTConstants.TOKEN_TYPE)
                .setIssuer(JWTConstants.TOKEN_ISSUER)
                .setAudience(JWTConstants.TOKEN_AUDIENCE)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 864000000))
                .compact();
        response.addHeader(JWTConstants.TOKEN_HEADER, JWTConstants.TOKEN_PREFIX + token);
    }
}
