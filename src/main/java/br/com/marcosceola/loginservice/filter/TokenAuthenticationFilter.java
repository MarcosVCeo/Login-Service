package br.com.marcosceola.loginservice.filter;

import br.com.marcosceola.loginservice.service.TokenService;
import br.com.marcosceola.loginservice.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UserService userService;

    public TokenAuthenticationFilter(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var token = getToken(request.getHeader("Authorization"));

        if (tokenService.isValidToken(token)) {
            authenticateUser(token);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(String headerAuthorization) {
        if (headerAuthorization == null || headerAuthorization.isEmpty() || headerAuthorization.isBlank() || !headerAuthorization.startsWith("Bearer ")) {
            return null;
        }

        return headerAuthorization.substring(7);
    }

    private void authenticateUser(String token) {
        var user = userService.find(tokenService.getUserId(token));
        var authentication = new UsernamePasswordAuthenticationToken(
            user,
            null,
            user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
