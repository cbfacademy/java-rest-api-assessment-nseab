package com.cbfacademy.apiassessment;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication(scanBasePackages = "com.cbfacademy.apiassessment")
public class App implements CommandLineRunner {

    @Autowired
    WeatherRepository weatherRepository;

    @Override
    public void run(String... args) throws Exception {
        Weather e1 = new Weather(1, "London", "England", 10, "windy");
        Weather e2 = new Weather(2, "Paris", "France", 13, "cloudy");
        Weather e3 = new Weather(3, "Hamburg", "Germany", 8, "rain");
        Weather e4 = new Weather(4, "Moscow", "Russia", 7, "light drizzle");
        Weather e5 = new Weather(5, "Vienna", "Austria", 10, "rain");
        Weather e6 = new Weather(6, "Barelona", "Spain", 18, "sunny");
        Weather e7 = new Weather(7, "Istanbul", "Turkiye", 17, "clear with periodic clouds");
        Weather e8 = new Weather(8, "Abu Dhabi", "UAE", 29, "clear with periodic clouds");
        Weather e9 = new Weather(9, "Lagos", "Nigeria", 21, "mostly sunny");
        Weather e10 = new Weather(10, "Accra", "Ghana", 29, "sunny");

        weatherRepository.getWeather().addAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));

    }

    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }
}


	
		

	


