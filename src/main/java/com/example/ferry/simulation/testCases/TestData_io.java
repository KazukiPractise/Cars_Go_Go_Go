package com.example.ferry.simulation.testCases;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class TestData_io {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void saveToJson(TestData data, String filename) throws Exception {
        mapper.writeValue(new File(filename), data);
    }

    public static TestData loadFromJson(String filename) throws Exception {
        return mapper.readValue(new File(filename), TestData.class);
    }
}
