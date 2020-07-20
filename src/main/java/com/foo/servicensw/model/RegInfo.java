package com.foo.servicensw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "reg_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name="reg_info_id")
    private Integer regInfoId;

    @Column(name="plate_number")
    private String plateNumber;

    @OneToOne(cascade = {PERSIST, REMOVE, MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "reg_id")
    private Registration registration;

    @OneToOne(cascade = {PERSIST, REMOVE, MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToOne(cascade = {PERSIST, REMOVE, MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "insurer_id")
    private Insurer insurer;

}
