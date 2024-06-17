package eu.epfc.j1888.fly.repositories;

import eu.epfc.j1888.fly.entities.Fly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlyRepository extends JpaRepository<Fly, Long> {
}
