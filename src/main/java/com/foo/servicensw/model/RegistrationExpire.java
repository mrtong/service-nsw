package com.foo.servicensw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

//this is really not a good desgin though
@Entity
@Table(name = "registration")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationExpire {
}
