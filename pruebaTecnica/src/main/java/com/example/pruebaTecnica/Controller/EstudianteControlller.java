package com.example.pruebaTecnica.Controller;


import com.example.pruebaTecnica.Entity.Estudiante;
import com.example.pruebaTecnica.Service.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/estudiante")
public class EstudianteControlller {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @GetMapping
    public List<Estudiante> getAll(){
        return estudianteServicio.getEstudiantes();
    }

    @GetMapping("/{estudianteId}")
    public Optional<Estudiante> getById(@PathVariable("estudianteId") Long estudianteId){
        return estudianteServicio.getEstudiantes(estudianteId);
    }

    @PostMapping
    public void save(@RequestBody Estudiante estudiante){
        estudianteServicio.save(estudiante);
    }

    @DeleteMapping("/{estudianteId}")
    public void delete(@PathVariable("estudianteId") Long estudianteId){
        estudianteServicio.delete(estudianteId);
    }
}

