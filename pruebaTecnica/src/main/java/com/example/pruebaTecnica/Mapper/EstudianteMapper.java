package com.example.pruebaTecnica.Mapper;

import com.example.pruebaTecnica.DTO.EstudianteDTO;
import com.example.pruebaTecnica.Entity.Estudiante;

public class EstudianteMapper {

    // Convierte de Entidad a DTO
    public static EstudianteDTO toDTO(Estudiante estudiante) {
        return new EstudianteDTO(estudiante.getPrimerNombre(), estudiante.getPrimerApellido());
    }

    // Convierte de DTO a Entidad
    public static Estudiante toEntity(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = new Estudiante();
        estudiante.setPrimerNombre(estudianteDTO.getPrimerNombre());
        estudiante.setPrimerApellido(estudianteDTO.getPrimerApellido());
        return estudiante;
    }
}
