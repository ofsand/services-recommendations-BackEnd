package org.capgemini.servicesrecommendationbackEnd;

import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.AdminServiceInterface;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.CategoryServiceInterface;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.ServiceTradesPersonServiceInterface;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.UserServiceInterface;
import org.capgemini.servicesrecommendationbackEnd.models.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.models.dto.ServiceDto;
import org.capgemini.servicesrecommendationbackEnd.mapper.CategoryMapper;
import org.capgemini.servicesrecommendationbackEnd.models.entities.TradesPerson;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;
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
	CommandLineRunner start(AdminServiceInterface adminBusiness,
							UserServiceInterface userBusiness,
							//RoleBusiness roleBusiness,
							CategoryServiceInterface categoryBusiness,
							CategoryMapper categoryMapper,
							ServiceTradesPersonServiceInterface serviceTradesPersonBusiness
	) {
		return args -> {

			//Save Roles
      /*
      Stream.of("ADMIN", "USER").forEach(name -> {
         Role role = new Role();
         role.setRole(name);
         roleBusiness.save(role);
      });*/
			//Save Categories
			List<CategoryDto> categories =
					Stream.of("Medical", "Painter", "Plumber").map(name -> {
						CategoryDto category = new CategoryDto();
						category.setName(name);
						return categoryBusiness.addCategory(category);
					}).collect(Collectors.toList());

			//Save Users
			Stream.of("zakaria", "aymane").forEach(name -> {
				User user = new User();
				user.setEmail(name+"@gmail.com");
				user.setUsername(name);
				user.setPassword(name);
				user.setPseudo(name);
				adminBusiness.add(user);
			});


			//Save Service
			ServiceDto service = new ServiceDto();
			service.setEmail("service@gmail.com");
			service.setTitle("title 1");
			service.setPhoneNumber("0766131555");
			service.setLocation("kenitra");
			//serviceTradesPersonBusiness.add(service);
			//Save Trades Person
			TradesPerson tradesPerson = new TradesPerson();
			tradesPerson.setEmail("service@gmail.com");
			tradesPerson.setTitle("title 1");
			tradesPerson.setPhoneNumber("0766131555");
			categories.stream().findFirst().orElse(null);
			tradesPerson.setFirstName("zakaria");
			tradesPerson.setLastName("chadli");
			tradesPerson.setSpeciality("Medecin");
			//serviceTradesPersonBusiness.add(tradesPerson);
		};
	};
	@Bean
	PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
