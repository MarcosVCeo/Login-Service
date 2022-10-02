package br.com.marcosceola.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class LoginServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginServiceApplication.class, args);
    }
}
