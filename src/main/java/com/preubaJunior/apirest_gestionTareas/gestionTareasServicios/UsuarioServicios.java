package com.preubaJunior.apirest_gestionTareas.gestionTareasServicios;

import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.LoginDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.UsuarioDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTareasMappers.UsuarioMappers;
import com.preubaJunior.apirest_gestionTareas.gestionTareasRepositorios.UsuarioRepositorio;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

//Servicios de usuario
@Service
public class UsuarioServicios {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Crear usuario
    public Usuario crear(UsuarioDTO usuarioDTO) {
        if (usuarioRepositorio.findByEmail(usuarioDTO.getEmail()).isPresent())
            throw new IllegalArgumentException("Email ya registrado");
        Usuario usuario = UsuarioMappers.toEntity(usuarioDTO,passwordEncoder);
        return usuarioRepositorio.save(usuario);
    }

    //Encontrar usuario por su id
    public Usuario obtener(Long id) {
        return usuarioRepositorio.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    //Login de usuario
    public Usuario login(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepositorio.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!passwordEncoder.matches(loginDTO.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return usuario;
    }

}
