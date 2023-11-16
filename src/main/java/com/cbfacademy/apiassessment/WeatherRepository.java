package com.cbfacademy.apiassessment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

	@Repository
	public class WeatherRepository {
	
		
	public List<Weather> weather = new ArrayList<Weather>();

	public List<Weather> getAll() {
		return weather;
	}

	public String add(Weather weather) {
		this.weather.add(weather);
		return "successfully added";
	}
}