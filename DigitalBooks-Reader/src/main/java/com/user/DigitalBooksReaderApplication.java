package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
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
@EnableEurekaClient
public class DigitalBooksReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBooksReaderApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

@Configuration
@EnableSwagger2
class SwaggerConfig {
	@Bean
	public Docket APIs() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata()).select()
				.apis(RequestHandlerSelectors.basePackage("com.user")).paths(PathSelectors.any()).build();
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("<DigitalBookS-Reader>").description("<BookMicroservice CRUD API Documentation>")
				.version("BETA").build();
	}
}