package com.veterinaria.springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_duenio;

    private String dni;
    private String nombre;
    private String apellido;
    private String celular;




}
