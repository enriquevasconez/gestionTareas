package com.preubaJunior.apirest_gestionTareas.gestionTareasServicios;

import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.TareasDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTareasMappers.TareasMappers;
import com.preubaJunior.apirest_gestionTareas.gestionTareasRepositorios.TareasRepositorio;
import com.preubaJunior.apirest_gestionTareas.gestionTareasRepositorios.UsuarioRepositorio;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Tareas;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

//Servicios de tareas
@Service
public class TareasServicios {
    @Autowired
    private TareasRepositorio tareasReposotorio;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    //Crear nueva tarea por id usuario
    public Tareas crearTareas(Long usuarioId, TareasDTO tareasDTO){
        Usuario usuario = usuarioRepositorio.findById(usuarioId).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
        Tareas tareas = TareasMappers.toEntity(tareasDTO, usuario);
        return tareasReposotorio.save(tareas);
    }

    //Listar Tareas por Usuario id
    public List<Tareas> listarTareasPorUsuario(Long usuarioId) {
        if (!usuarioRepositorio.existsById(usuarioId)) {
            throw new NoSuchElementException("Usuario no existe");
        }
        return tareasReposotorio.findByUsuarioId(usuarioId);
    }

    //Actualizar tarea por id
    public Tareas actualizarTarea(Long tareaId, Long usuarioId ,TareasDTO tareasDTO) {
        Tareas tareas = tareasReposotorio.findById(tareaId)
                .orElseThrow(() -> new NoSuchElementException("Tarea no encontrada"));

        if (!tareas.getUsuario().getId().equals(usuarioId)) {
            throw new RuntimeException("No autorizado");
        }

        tareas.setTitulo(tareasDTO.getTitulo());
        tareas.setDescripcion(tareasDTO.getDescripcion());
        tareas.setEstado(tareasDTO.getEstado());
        tareas.setfechaActualizacion(LocalDateTime.now());
        return tareasReposotorio.save(tareas);
    }


    //Eliminar Tarea por id
    public void eliminar(Long tareaId, Long usuarioId) {
        Tareas tareas = tareasReposotorio.findById(tareaId)
                .orElseThrow(() -> new NoSuchElementException("Tarea no encontrada"));

        if (!tareas.getUsuario().getId().equals(usuarioId)) {
            throw new RuntimeException("No autorizado");
        }
        tareasReposotorio.deleteById(tareaId);
    }



}
