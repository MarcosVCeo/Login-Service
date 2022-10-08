package br.com.marcosceola.loginservice.controller;

import br.com.marcosceola.loginservice.dto.RegisterUserForm;
import br.com.marcosceola.loginservice.model.User;
import br.com.marcosceola.loginservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserControler {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping
    public List<User> listUsers() {
        return userService.list();
    }

    @PutMapping
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterUserForm registerUserForm) {
        return null;
    }
}
