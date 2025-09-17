package com.preubaJunior.apirest_gestionTareas.gestionTareasDTO;

import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Estado;
import jakarta.validation.constraints.NotBlank;

public class TareasDTO {
    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;
    private Estado estado = Estado.PENDIENTE;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
