package com.preubaJunior.apirest_gestionTareas.gestionTareasServicios;


import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.UsuarioDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTareasRepositorios.UsuarioRepositorio;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//Pruebas unitarias
@ExtendWith(MockitoExtension.class)
public class UsuarioServiciosTest {

    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    @Mock
    private PasswordEncoder passwordEncoder;


    @InjectMocks
    private UsuarioServicios usuarioServicios;

    //Prueba para crear usuario
    @Test
    public void pruebaCrearUsuario(){
        UsuarioDTO dto = new UsuarioDTO("Enrique", "nuevo@mail.com", "1234");
        //Simular que emial no está registrado
        when(usuarioRepositorio.findByEmail("nuevo@mail.com")).thenReturn(Optional.empty());
        //Simula encriptación
        when(passwordEncoder.encode("1234")).thenReturn("hash1234");

        Usuario usuarioMock = new Usuario();
        usuarioMock.setNombre("Enrique");
        usuarioMock.setEmail("nuevo@mail.com");
        usuarioMock.setPassword("1234");

        when(usuarioRepositorio.save(any(Usuario.class))).thenReturn(usuarioMock);

        Usuario resultado = usuarioServicios.crear(dto);
        assertNotNull(resultado);
        assertEquals("Enrique", resultado.getNombre());
        assertEquals("nuevo@mail.com", resultado.getEmail());

    }

    //Prueba para validar que el email es duplicado
    @Test
    public void testCrearUsuario_emailDuplicado() {
        UsuarioDTO dto = new UsuarioDTO("Enrique", "nuevo@mail.com", "1234");

        Usuario existente = new Usuario();
        existente.setEmail("nuevo@mail.com");
        //Simula emial duplicado
        when(usuarioRepositorio.findByEmail("nuevo@mail.com")).thenReturn(Optional.of(existente));
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            usuarioServicios.crear(dto);
        });

        assertEquals("Email ya registrado", ex.getMessage());
    }

}

