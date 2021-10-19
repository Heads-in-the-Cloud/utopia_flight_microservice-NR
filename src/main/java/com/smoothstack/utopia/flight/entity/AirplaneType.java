package com.smoothstack.utopia.flight.entity;

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
@ToString
@Setter
@Entity
@Table(name = "airplane_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AirplaneType {
    @Id
    private int id;
    @Column(name = "max_capacity")
    private int maxCapacity;
}
