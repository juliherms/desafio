package com.compasso.desafio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe responsável por configurar o Swagger
 * 
 * @author j.a.vasconcelos
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Value("${spring.api.version}")
	private String version;

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.compasso.desafio")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Compasso API").description("API Spring Boot").version(version).build();
	}
}
