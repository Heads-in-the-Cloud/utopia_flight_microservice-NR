package com.smoothstack.utopia.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "route")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Route {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Airport origin;
    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Airport destination;

    public boolean isComplete() {
        return origin != null && origin.isComplete() && destination != null && destination.isComplete();
    }
}
