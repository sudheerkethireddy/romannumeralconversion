package org.adobe.aem.romannumeralconversion;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class for the application. In other words, its the entry point to the API.
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Roman Numeral Conversion API", version = "1.0", description = "This API supports converting integer to roman Numeral. Currently only GET call is supported"))
public class RomanNumericServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RomanNumericServiceApplication.class, args);
    }

}