package com.example.pruebaTecnica.Service;

import com.example.pruebaTecnica.DTO.EstudianteDTO;
import com.example.pruebaTecnica.Entity.Estudiante;
import com.example.pruebaTecnica.Repository.EstudianteRepository;
import com.example.pruebaTecnica.Mapper.EstudianteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteServicio {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // ====== MÉTODOS SIN DTO ======

    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getEstudiantes(Long id) {
        return estudianteRepository.findById(id);
    }

    public void save(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }

    // ====== MÉTODOS CON DTO ======

    public List<EstudianteDTO> getEstudiantesDTO() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
                .map(EstudianteMapper::toDTO) // Conversión de entidad a DTO
                .collect(Collectors.toList());
    }

    public Optional<EstudianteDTO> getEstudianteDTO(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.map(EstudianteMapper::toDTO); // Mapea la entidad a DTO si existe
    }

    public void save(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = EstudianteMapper.toEntity(estudianteDTO); // Conversión de DTO a entidad
        estudianteRepository.save(estudiante);
    }
}