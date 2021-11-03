package com.smoothstack.utopia.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "airplane")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airplane {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private AirplaneType airplaneType;

    public Airplane(int id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isComplete() {
        return airplaneType != null;
    }
}
