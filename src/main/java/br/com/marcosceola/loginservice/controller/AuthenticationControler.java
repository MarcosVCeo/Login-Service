package br.com.marcosceola.loginservice.controller;

import br.com.marcosceola.loginservice.dto.LoginForm;
import br.com.marcosceola.loginservice.dto.TokenDTO;
import br.com.marcosceola.loginservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("auth")
public class AuthenticationControler {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm loginForm) {
        try {
            var token = tokenService
                .generateToken(authenticationManager.authenticate(loginForm.toUsernamePasswordAuthenticationToken()));

            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
