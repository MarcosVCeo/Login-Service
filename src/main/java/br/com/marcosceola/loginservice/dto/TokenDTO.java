package br.com.marcosceola.loginservice.dto;

public class TokenDTO {

    private String token;
    private String authenticationTipe;

    public TokenDTO(String token, String authenticationTipe) {
        this.token = token;
        this.authenticationTipe = authenticationTipe;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthenticationTipe() {
        return authenticationTipe;
    }

    public void setAuthenticationTipe(String authenticationTipe) {
        this.authenticationTipe = authenticationTipe;
    }
}
