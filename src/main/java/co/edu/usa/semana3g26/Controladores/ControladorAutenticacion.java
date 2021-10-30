/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.Controladores;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase Controller ControladorAutenticacion
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
@RestController
public class ControladorAutenticacion {

    /**
     * Método para obtener datos de autenticación OAuth2
     *
     * @param auth_data datos del usuario recibidos del autenticador
     * @return datos solicitados para autenticación
     */
    @GetMapping("/user")
    public Map<String, Object> user(
            @AuthenticationPrincipal OAuth2User auth_data) {
        return Collections.singletonMap("name", auth_data.getAttribute("name"));
    }    
}
