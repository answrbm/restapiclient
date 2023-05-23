package ansarbektassov;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class App
{
    public static void main( String[] args ) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
//        **************************************
//        SENSOR REGISTRATION

//        Map<String, String> json = new HashMap<>();
//        json.put("name","test_sensor");
//
//        HttpEntity<Map<String,String>> request = new HttpEntity<>(json);
//
//        String registerSensor = "http://localhost:8080/sensors/registration";
//        String response = restTemplate.postForObject(registerSensor,request,String.class);
//
//        System.out.println(response);
//        ******************************************
//        MEASUREMENTS CREATION
//        double rangeMin = -100;
//        double rangeMax = 100;
//        Random r = new Random();
//
//        Map<String, Object> json = new HashMap<>();
//        HttpEntity<Map<String,Object>> request = new HttpEntity<>(json);
//        Map<String, String> sensorJson = new HashMap<>();
//        sensorJson.put("name","test_sensor");
//
//        String createMeasurement = "http://localhost:8080/measurements/add";
//
//        for(int i = 0; i < 1000; i++) {
//            double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
//            json.put("value",randomValue);
//            json.put("raining",r.nextBoolean());
//            json.put("sensor",sensorJson);
//            String response = restTemplate.postForObject(createMeasurement,request,String.class);
//            System.out.println(response);
//        }
//        ******************************************
        String registerSensor = "http://localhost:8080/measurements";

        List<String> response = restTemplate.getForObject(registerSensor, List.class);
        System.out.println(response);

        for(String jsonObject : response) {
            Measurement measurement = new ObjectMapper().readValue(jsonObject,Measurement.class);

            System.out.println(measurement);
        }
//        ******************************************
    }
}
