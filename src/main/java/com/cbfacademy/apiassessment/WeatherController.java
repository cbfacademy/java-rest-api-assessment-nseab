package com.cbfacademy.apiassessment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weather")
public class WeatherController {
	@Autowired
	WeatherService weatherService;
	//Get a list of all cities and weather
	@GetMapping("/")
	@ResponseBody
	public List<Weather> getWeather() {
		
		return weatherService.getAll();
	}
	
	//add a city to the weather list
	@PostMapping("/add")
	public ResponseEntity<Object> createWeather(@RequestBody Weather newWeather) {
	    int cityId = newWeather.getCityId();
	    List<Weather> allCities = weatherService.getAll();

	    // Check if cityId already exists
	    for (Weather weather : allCities) {
	        if (weather.getCityId() == cityId) {
	            // Return a response with a 404 status and message
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a new cityId greater than 10.");
	        }
	    }

	    // CityId doesn't exist, so add the newWeather
	    //newWeather.setCityId(cityId);
	    weatherService.add(newWeather);

	    // Return a response with a 201 status and the newly created Weather object
	    return ResponseEntity.status(HttpStatus.CREATED).body(newWeather);
	}

	
	@GetMapping("/get/{cityId}")
	@ResponseBody
	public ResponseEntity<Object> getWeatherByCityId(@PathVariable int cityId) {
	    List<Weather> allCities = weatherService.getAll();

	    // Iterate through the list to find the Weather with the specified cityId
	    for (Weather weather : allCities) {
	        if (weather.getCityId() == cityId) {
	        	return ResponseEntity.ok(weather);
	        }
	    }

	    // Check if a valid city was found
//	    if (foundWeather != null) {
//	        return foundWeather;
//	    } else {
//	        System.out.println("Please select a valid cityId between 1 and 10.");
//	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please select a valid cityId between 1 and 10.");
	}
	
	@PutMapping("/update/{cityId}")
	public ResponseEntity<Object> updateCity(@PathVariable int cityId, Weather updatedWeather) {
		List<Weather> allCities = weatherService.getAll();
		for (Weather weather : allCities) {
			if (weather.getCityId() == cityId) {
				weather.setCity(updatedWeather.getCity());
				weather.setCountry(updatedWeather.getCountry());
				weather.setTemperature(updatedWeather.getTemperature());
				weather.setCondition(updatedWeather.getCondition());
				System.out.println("You have successfully updated " + cityId);
				return ResponseEntity.ok(weather);
			}
	}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please check the cityId use the website localhost:8080/weather/ for the full weather list");
	}
	
//	
	
	@DeleteMapping("/delete/{cityId}")
	public void deleteCity(@PathVariable int cityId) 
	{
		List<Weather> allCities = weatherService.getAll();
		allCities.removeIf(weather -> weather.getCityId() == cityId);
		System.out.println(weatherService.getAll());
	}
	
}