package pl.put.poznan.buildinginfo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.buildinginfo.rest"})
public class BuildingInfoApplication {

    private static final Logger log = LoggerFactory.getLogger(BuildingInfoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
