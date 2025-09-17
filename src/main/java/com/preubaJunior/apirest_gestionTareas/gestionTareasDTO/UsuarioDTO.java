package com.preubaJunior.apirest_gestionTareas.gestionTareasDTO;

import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "El correo no puede estar vacío")
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacío")
    private String password;

    // Constructor completo
    public UsuarioDTO(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    // Constructor vacío
    public UsuarioDTO() {
    }


    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



