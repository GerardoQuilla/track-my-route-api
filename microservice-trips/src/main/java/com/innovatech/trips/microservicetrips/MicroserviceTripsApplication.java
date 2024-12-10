package com.innovatech.trips.microservicetrips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceTripsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTripsApplication.class, args);
	}

}
