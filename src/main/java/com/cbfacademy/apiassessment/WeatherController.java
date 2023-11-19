package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	WeatherService weatherService;

	@Autowired
	WeatherDataFileWriter fileWriter;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Weather> getWeather() {
		try {
			List<Weather> weatherList = weatherService.getAll();
			fileWriter.writeJsonToFile(weatherList, "outputWeatherListFile.json");
			return weatherList;
		} catch (Exception e) {
			return (List<Weather>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An internal server error occurred.");
		}
		}

		//add a city to the weather list
		@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> createWeather(@Validated @RequestBody Weather newWeather, BindingResult bindingResult) {
			// Check for validation errors
			if (bindingResult.hasErrors()) {
				List<FieldError> errors = bindingResult.getFieldErrors();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error: " + errors.toString());
			}
			int cityId = newWeather.getCityId();

			List<Weather> weatherList = weatherService.getAll();
			for (Weather weather : weatherList) {
				if (weather.getCityId() == cityId) {
					// Return a response with a 404 status and message
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a new cityId greater than 10.");
				}
			}

			// CityId doesn't exist, so add the newWeather
			weatherService.add(newWeather);

			fileWriter.writeJsonToFile(weatherList, "newWeatherData.json");
			System.out.println("Data successfully written to newWeatherData.json");

			// Return a response with a 201 status and the newly created Weather object
			return ResponseEntity.status(HttpStatus.CREATED).body(newWeather);
		}


		@GetMapping(value = "/get/{cityId}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<Object> getWeatherByCityId(@PathVariable int cityId) {

			// Iterate through the list to find the Weather with the specified cityId
			List<Weather> weatherList = weatherService.getAll();
			for (Weather weather : weatherList) {
				if (weather.getCityId() == cityId) {
					// Write JSON data to file
					fileWriter.writeJsonToFile(weatherList, "outputGetCityFile.json");
					return ResponseEntity.ok(weather);
				}
			}

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please select a valid cityId between 1 and 10.");
		}

		@PutMapping("/update/{cityId}")
		public ResponseEntity<Object> updateWeather(@PathVariable int cityId, Weather updatedWeather) {
			List<Weather> weatherList = weatherService.getAll();
			for (Weather weather : weatherList) {
				if (weather.getCityId() == cityId) {
					weather.setCity(updatedWeather.getCity());
					weather.setCountry(updatedWeather.getCountry());
					weather.setTemperature(updatedWeather.getTemperature());
					weather.setCondition(updatedWeather.getCondition());
					System.out.println("You have successfully updated " + cityId);
					return ResponseEntity.ok(weather);
				}
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please check the cityId, refer to the website 'localhost:8080/weather/' for the full weather list");
		}

		@DeleteMapping("/delete/{cityId}")
		public ResponseEntity<Object> deleteWeather(@PathVariable int cityId) {
			List<Weather> weatherList = weatherService.getAll();
			boolean removed = weatherList.removeIf(weather -> weather.getCityId() == cityId);

			if (removed) {
				fileWriter.writeJsonToFile(weatherList, "updatedWeatherListFile.json");
				return ResponseEntity.ok("City with ID " + cityId + " successfully deleted.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City with ID " + cityId + " not found.");
			}
		}

	}