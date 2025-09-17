package com.preubaJunior.apirest_gestionTareas.gestionTareasRepositorios;

import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Repositorio de tareas
public interface TareasRepositorio extends JpaRepository<Tareas, Long> {
    List<Tareas> findByUsuarioId(Long usuarioId);
}
