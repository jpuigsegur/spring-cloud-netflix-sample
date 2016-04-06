package com.sample;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class MicroserviceOneApiDocumentation {
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(regex("/microservice-one/.*"))
            .build()
            .pathMapping("/")
            .apiInfo(metadata());
    }

    @Bean
    public UiConfiguration swaggerUiConfig() {
        return UiConfiguration.DEFAULT;
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
            .title("API microservice one example")
            .description("Great description of the API microservice one example")
            .version("1.0")
            .contact(new Contact("xxxxx", "http://some.url", "xxxxx@gmail.com"))
            .build();
    }
}
