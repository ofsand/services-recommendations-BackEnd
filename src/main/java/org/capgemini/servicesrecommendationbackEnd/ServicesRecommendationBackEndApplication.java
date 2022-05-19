package org.capgemini.servicesrecommendationbackEnd;

import org.capgemini.servicesrecommendationbackEnd.models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ServicesRecommendationBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesRecommendationBackEndApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner start(UserBusiness userBusiness,
							RoleBusiness roleBusiness,
							CategoryBusiness categoryBusiness,
							ServiceTradesPersonBusiness serviceTradesPersonBusiness) {
		return args -> {

			//Save Roles
			Stream.of("ADMIN", "USER").forEach(name -> {
				Role role = new Role();
				role.setRole(name);
				roleBusiness.save(role);
			});

			//Save Categories
			List<Category> categories =
					Stream.of("Medical", "Painter", "Plumber").map(name -> {
						Category category = new Category();
						category.setName(name);
						return categoryBusiness.save(category);
					}).collect(Collectors.toList());

			//Save Users
			Stream.of("zakaria", "aymane").forEach(name -> {
				User user = new User();
				user.setEmail(name+"@gmail.com");
				user.setPassword(name);
				user.setPseudo(name);
				userBusiness.save(user);
			});


			//Save Service
			Service serviceTradesPerson = new Service();
			serviceTradesPerson.setEmail("service@gmail.com");
			serviceTradesPerson.setTitle("title 1");
			serviceTradesPerson.setPhoneNumber("0766131555");
			serviceTradesPerson.setCategory(categories.stream().findFirst().orElse(null));
			serviceTradesPerson.setLocation("kenitra");
			serviceTradesPersonBusiness.save(serviceTradesPerson);
		};
	}
	*/
}
