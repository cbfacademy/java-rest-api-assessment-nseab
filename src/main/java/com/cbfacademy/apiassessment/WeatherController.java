package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;

	@GetMapping("/get/all")
	public List<Weather> getAll() {
		return weatherService.getAll();
	}
	
	@PostMapping("/add")
	public String getAll(@RequestBody Weather weather) 
	{	
		return weatherService.add(weather);
	}
	
//	@PutMapping("/update/city")
//	public String updateCity() 
//	{
//		return "city has been updated.";
//	}
//	
//	@DeleteMapping("/remove/city")
//	public String removeCity() 
//	{
//		return city + " has been removed from the file.";
//	}
	
}