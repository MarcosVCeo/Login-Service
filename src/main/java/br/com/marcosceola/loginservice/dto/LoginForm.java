package br.com.marcosceola.loginservice.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginForm {

    @NotNull
    @NotEmpty
    @NotBlank
    private String username;

    @NotNull
    @NotEmpty
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsernamePasswordAuthenticationToken toUsernamePasswordAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(this.username, this.password);
    }
}
