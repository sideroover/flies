package eu.epfc.j1888.fly.repositories;
import eu.epfc.j1888.fly.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
