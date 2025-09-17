package com.preubaJunior.apirest_gestionTareas.gestionTareasMappers;

import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.UsuarioDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;

//Mappers para comunicar usuario DTO con objeto usuario
public class UsuarioMappers {
    public static Usuario toEntity(UsuarioDTO usuarioDTO, PasswordEncoder passwordEncoder) {
        return new Usuario(null, usuarioDTO.getNombre(), usuarioDTO.getEmail(), passwordEncoder.encode(usuarioDTO.getPassword()));
    }
}
