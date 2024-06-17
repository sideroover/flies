package eu.epfc.j1888.fly.configurations;
import eu.epfc.j1888.fly.entities.Airport;
import eu.epfc.j1888.fly.repositories.AirportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertAirportsIntoDatabase {
    Logger logger = LoggerFactory.getLogger(InsertAirportsIntoDatabase.class);
    @Bean
    CommandLineRunner insertAirports (AirportRepository repository) {
        return args -> {
            insertAirport(repository, "Brussels");
            insertAirport(repository, "London");
            insertAirport(repository, "Amsterdam");
            insertAirport(repository, "Berlin");
            insertAirport(repository, "Paris");
            insertAirport(repository, "Roma");
            insertAirport(repository, "Zurich");

        };
    }
    private void insertAirport(AirportRepository repository, String name) {
        Airport airport = new Airport(null, name);
        repository.save(airport);
        logger.info("insert " + airport);
    }
}