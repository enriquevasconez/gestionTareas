package com.preubaJunior.apirest_gestionTareas.gestionTareasDTO;

public class LoginDTO {
    private String email;
    private String password;

    //Constructor vació
    public LoginDTO() {
    }

    //Constructor completo
    public LoginDTO(String password, String email) {
        this.password = password;
        this.email = email;
    }

    //Getters y Setters
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
