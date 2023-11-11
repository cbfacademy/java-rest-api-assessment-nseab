package com.cbfacademy.apiassessment;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class App {

	public static void main(String[] args) {
		SpringApplication.run(WeatherController.class, args);
	//	WeatherController test = new WeatherController();
		
	}


//	@GetMapping("/greeting")
//	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return String.format("Hello %s", name);
	}
	
		
	}
	


