package com.sample.config;

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
 * 
 * 
 * @author Israel Rodríguez E.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.sample.controller";
	private static final String PROJECT_NAME = "sample-restfull";
	private static final String PROJECT_DESCRIPTION = "Sample API REST";
	private static final String VERSION = "1.0.0";
	

	/**
	 * Configuracion basica para swagger
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).select()

				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(PathSelectors.regex("/.*")).build()
				.apiInfo(apiEndPointsInfo());

	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title(PROJECT_NAME).description(PROJECT_DESCRIPTION).version(VERSION).build();

	}

}
