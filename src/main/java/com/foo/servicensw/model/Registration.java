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
@Table(name = "registrations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "reg_id")
    private Integer regId;

    @Column(name = "expired")
    @JsonProperty("expired")
    private boolean isExpired;

    @Column(name = "expiry_date")
    private String expiry_date;

}
