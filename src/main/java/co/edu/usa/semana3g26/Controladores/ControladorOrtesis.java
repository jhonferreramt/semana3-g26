/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.Controladores;

import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.servicios.ServiciosOrtesis;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * version 1.0 
 * Claase Controlador para Ortesis Ruta general api
 * @author Jhon Ferney Herrera 
 * Grupo G-26
 */
@RestController
@RequestMapping("/api/Ortopedic")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ControladorOrtesis {

    /**
     * Variable con referencia a Servicio Ortesis
     */
    @Autowired
    private ServiciosOrtesis servicio;

    /**
     * Método obtener Listado Ortesis
     *
     * @return formato JSON con datos lista Ortesis
     */
    @GetMapping("/all")
    public List<Ortesis> getOrtesis() {
        return servicio.getAll();
    }

    /**
     * Método Optional Obtener Ortesis por id valida
     *
     * @param ortesisId
     * @return ortesis para servicioOrtesis
     */
    @GetMapping("/{id}")
    public Optional<Ortesis> getOrtesis(@PathVariable("id") int ortesisId) {
        return servicio.getOrtesis(ortesisId);
    }

    /**
     * Método Guardar Ortesis
     *
     * @param ortesis
     * @return le retornamos a servicioOrtesis el JSON para la instruccion
     * update
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortesis save(@RequestBody Ortesis ortesis) {
        return servicio.save(ortesis);
    }

    /**
     * Método Crear Ortesis
     *
     * @param ortesis
     * @return le retornamos a servicioOrtesis el JSON para la instgruccion
     * update
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortesis update(@RequestBody Ortesis ortesis) {
        return servicio.update(ortesis);
    }

    /**
     * Método Borrar Ortesis
     *
     * @param ortesisId
     * @return le retornamos a servicioOrtesis el JSON para la instruccion
     * delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ortesisId) {
        return servicio.deleteOrtesis(ortesisId);
    }
}
