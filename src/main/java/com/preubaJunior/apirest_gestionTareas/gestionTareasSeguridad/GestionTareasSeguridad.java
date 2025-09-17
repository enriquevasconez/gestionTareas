package com.preubaJunior.apirest_gestionTareas.gestionTareasSeguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Seguridad básica
@Configuration
@EnableWebSecurity
public class GestionTareasSeguridad {

    //Permite acceso a las cabeceras
   @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http
               .csrf(AbstractHttpConfigurer::disable) // desactiva CSRF
               .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
               .formLogin(AbstractHttpConfigurer::disable)       // desactiva login HTML
               .httpBasic(AbstractHttpConfigurer::disable);    // desactiva login básico

       return http.build();
   }

    //Encriptacion de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

