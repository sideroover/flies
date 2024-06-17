package eu.epfc.j1888.fly.configurations;

import eu.epfc.j1888.fly.entities.Fly;
import eu.epfc.j1888.fly.repositories.FlyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class InsertFliesIntoDatabase {
    Logger logger = LoggerFactory.getLogger(InsertFliesIntoDatabase.class);
    @Bean
    CommandLineRunner insertFlies (FlyRepository repository) {
        return args -> {
            insertFly(repository, "A1", "Brussels", LocalDateTime.of(2024, 07, 01, 10, 32), "London", LocalDateTime.of(2024, 07, 01, 12, 20), "Simon Airlines", 421.23 );
            insertFly(repository, "B021", "Amsterdam", LocalDateTime.of(2024, 07, 01, 10, 39), "Brussels", LocalDateTime.of(2024, 07, 01, 11, 42), "Martin Airlines", 214.83  );
        };
    }
    private void insertFly(FlyRepository repository, String number, String departureAirport, LocalDateTime departureTime, String arrivalAirport, LocalDateTime arrivalTime, String company, double price) {
        Fly fly = new Fly(null, number, departureAirport,  departureTime, arrivalAirport, arrivalTime, company, price);
        repository.save(fly);
        logger.info("insert " + fly);
    }
}
