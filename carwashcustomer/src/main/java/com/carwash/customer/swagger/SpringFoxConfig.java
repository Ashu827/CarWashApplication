package com.carwash.customer.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SpringFoxConfig {
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.carwash.customer"))            
          .paths(PathSelectors.any())                          
          .build();
       // .apiInfo(metaData());
    }


	/*
	 * private ApiInfo metaData() { ApiInfo apiInfo = new ApiInfo(
	 * "Spring Boot REST API", "Spring Boot REST API for Online Store", "1.0",
	 * "Terms of service", new Contact("John Thompson",
	 * "https://springframework.guru/about/", "john@springfrmework.guru"),
	 * "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
	 * return apiInfo; }
	 */
}
