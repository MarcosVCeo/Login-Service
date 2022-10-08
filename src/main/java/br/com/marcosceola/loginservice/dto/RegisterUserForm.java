package br.com.marcosceola.loginservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegisterUserForm {

    @NotNull
    @NotBlank
    @NotEmpty
    private String Username;

    @NotNull
    @NotBlank
    @NotEmpty
    private String password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
