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
			Stream.of("admin").forEach(name -> {
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
					Stream.of("Médecine", "Peinture").map(name -> {
						CategoryDto category = new CategoryDto();
						category.setName(name);
						return categoryBusiness.addCategory(category);
					}).collect(Collectors.toList());

			// Service 1
			ServiceDto serviceDto = new ServiceDto();
			serviceDto.setTitle("Polyclinique Internationale de Rabat");
			serviceDto.setEmail("polyclinique-rabat@gmail.com");
			serviceDto.setDescription("La Polyclinique Internationale de Rabat est une structure hospitalière " +
					"privée, implantée depuis 1996 au cœur de la Capitale du Royaume du Maroc.");
			serviceDto.setPhoneNumber("0766131555");
			serviceDto.setLocation("Rabat, à côte du Mausolée Mohammed V، 8 Rue de Tunis");
			serviceTradesPersonBusiness.addService(serviceDto, 1L);

			//Save Trades Person 3
			TradesPersonDto tradesPerson3 = new TradesPersonDto();
			tradesPerson3.setTitle("Peintre, Hassan");
			tradesPerson3.setEmail("hassan.peintre@gmail.com");
			tradesPerson3.setPhoneNumber("0766131555");
			tradesPerson3.setDescription("Peintre qui a 12 années d'expérience dans le domaine de la peinture");
			tradesPerson3.setFirstName("Hassan");
			tradesPerson3.setLastName("Alaoui");
			tradesPerson3.setDomain("Peintre");
			tradesPerson3.setAddress("Sect 4E N°28 Rue El Hira Tabriquet, Salé 11000");
			tradesPerson3.setSpeciality("Peintre de maisons");
			serviceTradesPersonBusiness.addTradesPerson(tradesPerson3, 2L);
		};
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
