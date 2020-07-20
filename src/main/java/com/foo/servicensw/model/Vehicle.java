package com.foo.servicensw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "vehicle")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "vehicle_id")
    private Integer vehicleId;

    private String type;

    private String make;

    private String model;

    private String colour;

    private String vin;

    @JsonProperty("tare_weight")
    @Column(name = "tare_weight")
    private String tareWeight;

    @JsonProperty("gross_mass")
    @Column(name = "gross_mass")
    private String grossMass;
}
