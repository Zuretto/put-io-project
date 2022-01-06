package pl.put.poznan.buildinginfo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * main class of the Spring Boot Framework application
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildinginfo.*"})
public class BuildingInfoApplication {

    private static final Logger log = LoggerFactory.getLogger(BuildingInfoApplication.class);

    /**
     * main method of the application - starts the app
     * @param args arguments taken from the command line
     */
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }

    /**
     * Bean object responsible for mapping JSON objects into Java Objects
     * @param builder builder of the REST template
     * @return RestTemplate REST template for mapping JSON objects into Java objects
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
