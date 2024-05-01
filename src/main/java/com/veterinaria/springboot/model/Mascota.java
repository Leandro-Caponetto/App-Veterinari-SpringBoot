package com.veterinaria.springboot.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String especie;
    private String raza;
    private String color;

    @OneToOne
    @JoinColumn(name = "id_duenio", referencedColumnName = "id_duenio")
    private Duenio duenio;

}
