package com.peregud.travelhistorymvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.peregud.travelhistory.domain")
@EnableJpaRepositories("com.peregud.travelhistorymvc.repository")
public class TravelHistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelHistoryApplication.class, args);
    }

}
