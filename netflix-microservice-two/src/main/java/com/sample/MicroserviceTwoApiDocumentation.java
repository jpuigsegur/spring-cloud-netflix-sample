package com.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;

@Configuration
public class MicroserviceTwoApiDocumentation {
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(metadata())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.sample.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    @Bean
    public UiConfiguration swaggerUiConfig() {
        return UiConfiguration.DEFAULT;
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
            .title("API microservice one example")
            .description("Great description of the API microservice two example")
            .version("1.0")
            .contact(new Contact("xxxxx", "http://some.url", "xxxxx@gmail.com"))
            .build();
    }
}
