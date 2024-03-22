package com.turkcell.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
// @EnableDiscoveryClient => Eski versiyonlarda gerekli idi..
// @EnableEurekaClient
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}

	// CustomerService
	// DB Tasarımı
	// docker-compose'da CustomerService için gerekli konfigürasyonlar.
}
// 8:55