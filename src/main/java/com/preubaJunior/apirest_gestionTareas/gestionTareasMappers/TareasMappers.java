package com.preubaJunior.apirest_gestionTareas.gestionTareasMappers;

import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.TareasDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Estado;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Tareas;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Usuario;

import java.time.LocalDateTime;

//Mapper para comunicar tareaDTO con objeto Tarea
public class TareasMappers {
    public static Tareas toEntity(TareasDTO tareasDTO, Usuario usuario) {
        Tareas tarea = new Tareas();
        tarea.setTitulo(tareasDTO.getTitulo());
        tarea.setDescripcion(tareasDTO.getDescripcion());
        tarea.setEstado(tareasDTO.getEstado() != null ? tareasDTO.getEstado() : Estado.PENDIENTE);
        tarea.setfechaCreacion(LocalDateTime.now());
        tarea.setfechaActualizacion(LocalDateTime.now());
        tarea.setUsuario(usuario);
        return tarea;
    }

}
