package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

		@Autowired
		WeatherRepository weatherRepository;
		
		public List<Weather> getAll() {
		return weatherRepository.getAll();
		}
		
		public String add(Weather weather) {	
			weatherRepository.add(weather);
			return "successfully added";
		}

}

