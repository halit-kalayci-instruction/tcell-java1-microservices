package com.turkcell.authservice;

import com.halitkalayci.jwt.JwtService;
import com.halitkalayci.repositories.UserRepository;
import com.halitkalayci.services.abstracts.UserService;
import com.halitkalayci.services.concretes.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// TODO: Refactor
//@Import({JwtService.class, UserServiceImpl.class, UserRepository.class})
@ComponentScan(basePackages = {"com.halitkalayci"})
@EntityScan(basePackages = {"com.halitkalayci.entities"})
@EnableJpaRepositories(basePackages = {"com.halitkalayci.repositories"})
public class AuthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserviceApplication.class, args);
	}

}
