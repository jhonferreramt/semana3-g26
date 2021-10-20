/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.Controladores;

import co.edu.usa.semana3g26.modelo.Administrativo;
import co.edu.usa.semana3g26.servicios.ServiciosAdministrativo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase Controller ControladorAdministrativos
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorAdministrativos {

    /**
     * Variable que representa el servicio del administador
     */
    @Autowired
    private ServiciosAdministrativo admin_service;

    /**
     * Método para obtener el listado de administadores existentes
     *
     * @return listado de administadores en formato JSON
     */
    @GetMapping("/all")
    public List<Administrativo> getAll() {
        return (List<Administrativo>) admin_service.getAll();
    }

    /**
     * Método para obtener un administador específico por el identificador
     *
     * @param id identificador del administador
     * @return administador
     */
    @GetMapping("/{id}")
    public Administrativo getById(@PathVariable("id") int id) {
        return admin_service.getById(id);
    }

    /**
     * Método para crear un administador
     *
     * @param admin datos del administador a crear en formato JSON
     * @return administador en formato JSON
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrativo save(@RequestBody Administrativo admin) {
        return admin_service.save(admin);
    }
}
