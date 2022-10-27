package com.ddit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// http://localhost:8080/swagger-ui/index.html 로 접속합니다.
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.OAS_30)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.ddit")) // Swagger API 문서로 만들기 원하는 basePackage 경로입니다. (필수)
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());

        return docket;
    }

    // Swagger UI로 노출할 정보
    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Swagger Test");
        apiInfoBuilder.description("Swagger Testing");
        apiInfoBuilder.version("1.0");

        return apiInfoBuilder.build();
    }

}
