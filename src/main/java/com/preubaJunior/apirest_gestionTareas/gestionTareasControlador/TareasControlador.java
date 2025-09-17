package com.preubaJunior.apirest_gestionTareas.gestionTareasControlador;


import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.TareasDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTareasServicios.TareasServicios;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Tareas;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlador de tareas
@RestController
@RequestMapping("/tareas")
public class TareasControlador {

    //Servicios
    @Autowired
    private TareasServicios tareasServicios;

    //Crear tarea por id usuario
    @PostMapping("/{usuarioId}")
    public ResponseEntity<Tareas> crear(@PathVariable Long usuarioId, @RequestBody @Valid TareasDTO tareasDTO) {
        return ResponseEntity.ok(tareasServicios.crearTareas(usuarioId, tareasDTO));
    }

    //Listar tareas por id usuario
    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Tareas>> listar(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(tareasServicios.listarTareasPorUsuario(usuarioId));
    }

    //Actualizar tarea por id
    @PutMapping("/{tareaId}/usuario/{usuarioId}")
    public ResponseEntity<Tareas> actualizar(@PathVariable Long tareaId, @PathVariable Long usuarioId ,@RequestBody TareasDTO tareasDTO) {
        return ResponseEntity.ok(tareasServicios.actualizarTarea(tareaId, usuarioId,tareasDTO));
    }

    //Eliminar tarea por id
    @DeleteMapping("/{tareaId}/usuario/{usuarioId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long tareaId,@PathVariable Long usuarioId ) {
        tareasServicios.eliminar(tareaId, usuarioId);
        return ResponseEntity.noContent().build();
    }

}
