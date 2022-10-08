package br.com.marcosceola.loginservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket serviceAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.marcosceola.loginservice.controller"))
            .paths(PathSelectors.ant("/**"))
            .build()
            .apiInfo(getInfo())
            .globalRequestParameters(Arrays.asList(authorizationParameter()));
    }

    private ApiInfo getInfo() {
        return new ApiInfoBuilder()
            .title("Login-Service")
            .build();
    }

    private RequestParameter authorizationParameter() {
        var authParam = new RequestParameterBuilder();

        return authParam
            .name("Authorization")
            .description("access_token")
            .required(false)
            .in("header")
            .accepts(Collections.singleton(MediaType.APPLICATION_JSON))
            .build();
    }
}
