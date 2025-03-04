package com.example.pruebaTecnica.Repository;

import com.example.pruebaTecnica.Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository  extends JpaRepository<Estudiante, Long> {
}
