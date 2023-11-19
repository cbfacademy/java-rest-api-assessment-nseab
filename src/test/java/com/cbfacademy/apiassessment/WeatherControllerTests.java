//package com.cbfacademy.apiassessment;
//
//import com.cbfacademy.apiassessment.Weather;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(classes = App.class)
//public class WeatherControllerTests {
//	private WeatherController weatherController;
//    private List<Weather> weatherList;
//
//    @BeforeEach
//    public void setUp() {
//        weatherController = new WeatherController();
//        weatherList = new ArrayList<>();
//        weatherController.setWeatherService(new WeatherServiceStub(weatherList));
//    }
//
//    @Test
//    @DisplayName("Get Weather - Success")
//    public void testGetWeather() {
//        // Mock data
//        weatherList.add(new Weather(/* ... */));
//
//        // Perform the test
//        List<Weather> result = weatherController.getWeather();
//
//        // Assert the result
//        assertNotNull(result);
//        assertFalse(result.isEmpty());
//        assertEquals(weatherList, result);
//    }
//
//    @Test
//    @DisplayName("Create Weather - Success")
//    public void testCreateWeather_Success() {
//        // Mock data
//        Weather newWeather = new Weather(/* ... */);
//
//        // Perform the test
//        ResponseEntity<Object> result = weatherController.createWeather(newWeather, new BindingResultStub());
//
//        // Assert the result
//        assertEquals(HttpStatus.CREATED, result.getStatusCode());
//        assertNotNull(result.getBody());
//        assertEquals(newWeather, result.getBody());
//    }
//
//    @Test
//    @DisplayName("Create Weather - Validation Failure")
//    public void testCreateWeather_ValidationFailure() {
//        // Mock data
//        Weather invalidWeather = new Weather(/* ... */);
//        invalidWeather.setCityId(1); // Assuming this is an invalid cityId
//
//        // Perform the test
//        ResponseEntity<Object> result = weatherController.createWeather(invalidWeather, new BindingResultStub());
//
//        // Assert the result
//        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
//        assertNotNull(result.getBody());
//        assertTrue(result.getBody().toString().contains("Validation error"));
//    }
//
//    // Similar tests for other methods...
//
//    // Stub implementations for testing
//    private static class WeatherServiceStub implements WeatherService {
//        private final List<Weather> weatherList;
//
//        public WeatherServiceStub(List<Weather> weatherList) {
//            this.weatherList = weatherList;
//        }
//
//        @Override
//        public List<Weather> getAll() {
//            return weatherList;
//        }
//
//        // Implement other methods if needed
//    }
//
//    private static class BindingResultStub implements BindingResult {
//        @Override
//        public Object getTarget() {
//            return null;
//        }
//
//        // Implement other methods if needed
//    }
//}
