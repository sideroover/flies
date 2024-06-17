package eu.epfc.j1888.fly;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Fly {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "departure_airport", nullable = false)
    private String departureAirport;

    @Column(name = "departure_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime departureTime;

    @Column(name = "arrival_airport", nullable = false)
    private String arrivalAirport;

    @Column(name = "arrival_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime arrivalTime;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "price", nullable = false)
    private double price;
}
