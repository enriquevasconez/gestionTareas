package com.preubaJunior.apirest_gestionTareas.gestionTareasControlador;


import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.LoginDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTareasDTO.UsuarioDTO;
import com.preubaJunior.apirest_gestionTareas.gestionTareasServicios.UsuarioServicios;
import com.preubaJunior.apirest_gestionTareas.gestionTaresModelo.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controlador de usuario
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    //Servicios
    @Autowired
    private UsuarioServicios usuarioServicios;


    //Registrar usuario
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioServicios.crear(usuarioDTO));
    }

    //Obtener usuario
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioServicios.obtener(id));
    }

    //Login usuario
   @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(usuarioServicios.login(loginDTO));
    }
}
