package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan(basePackages="com.example.demo")
@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class)
@EnableJpaRepositories(basePackageClasses ={AbonnementRepository.class,UserService.class})
@EnableFeignClients
public class AbonnementServiceApplication extends SpringBootServletInitializer{
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
	    return builder.sources(AbonnementServiceApplication.class);
	  }

	public static void main(String[] args) {
		SpringApplication.run(AbonnementServiceApplication.class, args);
	}
	/*@Bean
	CommandLineRunner start(ProduitRepository productRepository,
							RepositoryRestConfiguration restConfiguration) {


		return args -> {
			restConfiguration.exposeIdsFor(Produit.class);

		};
	}*/
}
