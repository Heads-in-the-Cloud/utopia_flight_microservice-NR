package com.smoothstack.utopia.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "flight")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
    @Column(name = "departure_time")
    private Date departureTime;
    @Column(name = "reserved_seats")
    private int reservedSeats;
    @Column(name = "seat_price")
    private double seatPrice;

    @JsonIgnore
    public boolean isComplete() {
        return route != null && route.isComplete() && airplane != null && airplane.isComplete() && departureTime != null;
    }
}
