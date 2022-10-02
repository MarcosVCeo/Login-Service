package br.com.marcosceola.loginservice.filter;

import br.com.marcosceola.loginservice.service.TokenService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    public TokenAuthenticationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (!request.getRequestURI().equals("/auth")) {
            var token = getToken(request.getHeader("Authorization"));
            if (!tokenService.isValidToken(token)) {
                throw new RuntimeException("Token inválido");
            }
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(String headerAuthorization) {
        if (headerAuthorization == null
            || headerAuthorization.isEmpty()
            || headerAuthorization.isBlank()
            || !headerAuthorization.startsWith("Bearer ")) {

            throw new NoSuchElementException("Header authorizarion com token incorreto");
        }

        return headerAuthorization.substring(7);
    }
}
