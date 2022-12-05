package com.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@SpringBootApplication

public class DigitalBooksBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBooksBooksApplication.class, args);
	}

}

@Configuration
@EnableSwagger2
class SwaggerConfig {
	@Bean
	public Docket APIs() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select()
				.apis(RequestHandlerSelectors.basePackage("com.books")).paths(PathSelectors.any()).build();

	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("<DigitalBooks-Books>")
				.description("<BookMicroservice CRUD API Documentation>").version("BETA").build();
	}
}