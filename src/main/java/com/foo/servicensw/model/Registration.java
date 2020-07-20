package com.foo.servicensw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "registrations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer registrationId;

    @Column(name="plate_number")
    private String plateNumber;

    @OneToOne(cascade = {PERSIST, REMOVE, MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToOne(cascade = {PERSIST, REMOVE, MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "insurer_id")
    private Insurer insurer;

    @Column(name="expired")
    @JsonProperty("expired")
    private boolean isExpired;

    @Column(name="expiry_date")
    private String expiry_date;

}
