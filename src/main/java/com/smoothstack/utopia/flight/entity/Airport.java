package com.smoothstack.utopia.flight.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "airport")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airport {
    @Id
    @Column(name = "iata_id")
    private String iataId;
    private String city;

    public Airport(String iataId) {
        this.iataId = iataId;
    }

    @JsonIgnore
    public boolean isComplete() {
        return iataId != null && city != null;
    }
}
