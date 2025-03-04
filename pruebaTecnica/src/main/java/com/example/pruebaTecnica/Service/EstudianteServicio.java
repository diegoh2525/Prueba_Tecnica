package com.example.pruebaTecnica.Service;

import com.example.pruebaTecnica.Entity.Estudiante;
import com.example.pruebaTecnica.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {
    @Autowired
    EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getEstudiantes(Long id){
        return estudianteRepository.findById(id);
    }

    public void save(Estudiante estudiante){
        estudianteRepository.save(estudiante);
    }

    public void delete(Long id){
        estudianteRepository.deleteById(id);
    }
}
