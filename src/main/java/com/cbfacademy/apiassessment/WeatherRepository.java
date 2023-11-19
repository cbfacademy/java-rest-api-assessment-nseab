package com.cbfacademy.apiassessment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

	@Repository
	public class WeatherRepository {
	
		
	private List<Weather> weather = new ArrayList<Weather>();
	
	
	
	public List<Weather> getWeather() {
		return weather;
	}

	public boolean add(Weather weather) {
		this.weather.add(weather);
		return "successfully added" != null;
	}

	public void getWeatherByCityId() {
		
		
	}

			
	
}