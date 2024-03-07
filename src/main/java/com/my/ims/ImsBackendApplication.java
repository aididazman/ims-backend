package com.my.ims;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {

})
@EnableJpaRepositories("com.my.ims.repository")
@EnableJpaAuditing
@EntityScan("com.my.ims.domain")
@OpenAPIDefinition(
		info = @Info(
				title = "IMS back-end",
				description = "IMS back-end REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Muhammad Aidid",
						email = "aididazman98@gmail.com",
						url = "https://www.linkedin.com/in/muhammadaididazman/"
				)
		)
)
public class ImsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsBackendApplication.class, args);
	}

}
