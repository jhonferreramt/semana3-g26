/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.seguridad;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase Security AdaptadorSeguridad
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
@RestController
public class AdaptadorSeguridad extends WebSecurityConfigurerAdapter {

    /**
     * Método para configurar lo asociado a la autenticación OAuth2
     *
     * @param http información de la soliitud de autenticación
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(areq -> {
            try {
                areq.antMatchers("/", "/index.html", "/error", "/js/**",
                        "/css/**", "/img/**", "/webjars/**", "/api/**").
                        permitAll().anyRequest().authenticated().and().
                        logout().logoutSuccessUrl("/").permitAll();
            } catch (Exception ex) {
                Logger.getLogger(AdaptadorSeguridad.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }).exceptionHandling(exh -> exh.authenticationEntryPoint(
                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login().defaultSuccessUrl("/", true);

        http.cors().and().csrf().disable();
    }
}
