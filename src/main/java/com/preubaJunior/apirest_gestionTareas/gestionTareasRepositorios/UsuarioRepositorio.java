package com.preubaJunior.apirest_gestionTareas.gestionTareasRepositorios;

import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Repositorio de usuario
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
