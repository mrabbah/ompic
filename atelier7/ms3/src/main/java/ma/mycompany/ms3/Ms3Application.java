package ma.mycompany.ms3;

import java.util.Collections;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableSwagger2
@RefreshScope
public class Ms3Application {

	/*@Bean
	public KeycloakConfigResolver KeycloakConfigResolver() {
	    return new KeycloakSpringBootConfigResolver();
	}*/
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
		}

	private ApiInfo apiInfo() {
		return new ApiInfo("MS3 REST API",
				"L'API Public du Microservice 3 pour les Endpoints REST",
				"1.2",
				"Terms of service",
				new springfox.documentation.service.Contact("RABBAH", "www.ompic.ma", "mrabbah@gmail.com"),
				"Copyright OMPIC 2019", "API LICENCE URL", Collections.emptyList());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Ms3Application.class, args);
	}

}
