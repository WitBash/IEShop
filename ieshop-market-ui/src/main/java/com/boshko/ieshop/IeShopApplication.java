package com.boshko.ieshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = SessionAutoConfiguration.class)
public class IeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(IeShopApplication.class, args);
	}

}
