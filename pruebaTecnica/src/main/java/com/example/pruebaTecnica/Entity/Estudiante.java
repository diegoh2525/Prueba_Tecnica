package com.example.pruebaTecnica.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tabla_estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estudianteId;

    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

}
