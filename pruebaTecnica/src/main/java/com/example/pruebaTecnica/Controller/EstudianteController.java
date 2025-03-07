package com.example.pruebaTecnica.Controller;

import com.example.pruebaTecnica.DTO.EstudianteDTO;
import com.example.pruebaTecnica.Entity.Estudiante;
import com.example.pruebaTecnica.Service.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteServicio estudianteServicio;

    // ====== MÉTODOS SIN DTO ======

    @GetMapping
    public List<Estudiante> getAll() {
        return estudianteServicio.getEstudiantes(); // Llama al método que regresa entidades
    }

    @GetMapping("/{estudianteId}")
    public Optional<Estudiante> getById(@PathVariable("estudianteId") Long estudianteId) {
        return estudianteServicio.getEstudiantes(estudianteId); // Llama al método que regresa una entidad por ID
    }

    @PostMapping
    public void save(@RequestBody Estudiante estudiante) {
        estudianteServicio.save(estudiante); // Llama al método que guarda entidades
    }

    @DeleteMapping("/{estudianteId}")
    public void delete(@PathVariable("estudianteId") Long estudianteId) {
        estudianteServicio.delete(estudianteId); // Llama al método que elimina por ID
    }

    // ====== MÉTODOS CON DTO ======

    @GetMapping("/dto")
    public ResponseEntity<List<EstudianteDTO>> getAllDTO() {
        List<EstudianteDTO> estudiantes = estudianteServicio.getEstudiantesDTO(); // Llama al método que regresa DTOs
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/dto/{estudianteId}")
    public ResponseEntity<EstudianteDTO> getByIdDTO(@PathVariable("estudianteId") Long estudianteId) {
        Optional<EstudianteDTO> estudiante = estudianteServicio.getEstudianteDTO(estudianteId);
        return estudiante.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/dto")
    public ResponseEntity<Void> saveDTO(@RequestBody EstudianteDTO estudianteDTO) {
        estudianteServicio.save(estudianteDTO); // Llama al método que guarda DTOs
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}