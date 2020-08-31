package com.moim.addr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AddrApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddrApplication.class, args);
	}

}
