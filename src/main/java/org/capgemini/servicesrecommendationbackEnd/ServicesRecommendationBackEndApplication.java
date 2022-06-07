package org.capgemini.servicesrecommendationbackEnd;

import org.capgemini.servicesrecommendationbackEnd.models.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.TradesPersonDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Role;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;
import org.capgemini.servicesrecommendationbackEnd.services.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ServicesRecommendationBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesRecommendationBackEndApplication.class, args);
	}

	@Bean
	CommandLineRunner start(AdminService adminBusiness,
							UserService userBusiness,
							RoleService roleBusiness,
							CategoryService categoryBusiness,
							ServiceTradesPersonService serviceTradesPersonBusiness
	) {
		return args -> {

			//Save Roles
			Stream.of("ADMIN", "USER").forEach(name -> {
				Role role = new Role();
				role.setRole("ROLE_"+name);
				roleBusiness.add(role);
			});

			//Save Users
			Stream.of("admin", "fatiha").forEach(name -> {
				User user = new User();
				user.setEmail(name+"@gmail.com");
				user.setUsername(name);
				user.setPassword(name);
				user.setPseudo(name);
				userBusiness.addUser(user);
			});

			userBusiness.addRoleToUser(1L, 1L);

			//Save Categories
			List<CategoryDto> categories =
					Stream.of("Medical", "Painter", "Plumber").map(name -> {
						CategoryDto category = new CategoryDto();
						category.setName(name);
						return categoryBusiness.addCategory(category);
					}).collect(Collectors.toList());

			//Save Service

			ServiceDto serviceDto = new ServiceDto();
			serviceDto.setEmail("service@gmail.com");
			serviceDto.setDescription("this is a new service or trade person");
			serviceDto.setTitle("title 1");
			serviceDto.setPhoneNumber("0766131555");
			serviceDto.setLocation("kenitra");
			serviceTradesPersonBusiness.addService(serviceDto, 1L);

			//Save Trades Person
			TradesPersonDto tradesPerson = new TradesPersonDto();
			tradesPerson.setEmail("service@gmail.com");
			tradesPerson.setTitle("title 1");
			tradesPerson.setPhoneNumber("0766131555");
			tradesPerson.setFirstName("zakaria");
			tradesPerson.setLastName("chadli");
			tradesPerson.setDomain("Medical");
			tradesPerson.setAddress("23 Kenitra");
			tradesPerson.setSpeciality("Medecin");
			serviceTradesPersonBusiness.addTradesPerson(tradesPerson, 2L);

		};
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
