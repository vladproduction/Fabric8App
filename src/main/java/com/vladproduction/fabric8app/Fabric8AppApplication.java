package com.vladproduction.fabric8app;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Fabric8App",
				description = "documentation-api (SWAGGER-UI): product data service",
				version = "v1.0",
				contact = @Contact(
						name = "vladproduction",
						email = "vproductionsd@gmail.com",
						url = "https://github.com/vladproduction/Fabric8App"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/vladproduction/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring-Boot Products Management Documentation (CRUD operations)",
				url = "https://github.com/vladproduction/product_management.html"
		)
)
public class Fabric8AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Fabric8AppApplication.class, args);
	}

}
