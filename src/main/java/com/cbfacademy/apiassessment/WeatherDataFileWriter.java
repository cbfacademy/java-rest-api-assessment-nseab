package com.cbfacademy.apiassessment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WeatherDataFileWriter {

    private final ObjectMapper objectMapper;

    public WeatherDataFileWriter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void writeJsonToFile(List<Weather> weatherList, String fileName) {
        try {
            File file = new File(fileName);
            objectMapper.writeValue(file, weatherList);
            System.out.println("Data successfully written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing data to " + fileName);
        }
    }
}


	




