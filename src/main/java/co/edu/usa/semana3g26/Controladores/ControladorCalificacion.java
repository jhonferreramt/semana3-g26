/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.Controladores;

import co.edu.usa.semana3g26.modelo.Calificacion;
import co.edu.usa.semana3g26.servicios.ServiciosCalificacion;
import java.util.List;
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
 * Clase Controller ControladorCalificacion
 *
 * @version 1.1
 * @author Jhoan Villa G26 C3
 */
@RestController
@RequestMapping("api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorCalificacion {

    /**
     * Variable que representa el servicio del puntaje de la reservación
     */
    @Autowired
    private ServiciosCalificacion score_service;

    /**
     * Método para obtener el listado puntajes de reservaciones existentes
     *
     * @return listado de puntajes de reservaciones en formato JSON
     */
    @GetMapping("/all")
    public List<Calificacion> getAll() {
        return (List<Calificacion>) score_service.getAll();
    }

    /**
     * Método para obtener un puntaje de unaa reservación específica por el
     * identificador
     *
     * @param id identificador del puntaje de la reservación
     * @return puntaje de la reservación
     */
    @GetMapping("/{id}")
    public Calificacion getById(@PathVariable("id") int id) {
        return score_service.getById(id);
    }

    /**
     * Método para crear un puntaje de una reservación
     *
     * @param score datos del puntaje de la reservación a crear en formato JSON
     * @return puntaje de la reservación en formato JSON
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion save(@RequestBody Calificacion score) {
        return score_service.save(score);
    }

    /**
     * Método para modificar un puntaje de una reservación
     *
     * @param score datos del puntaje de la reservación a modificar en formato
     * JSON
     * @return puntaje de la reservación en formato JSON
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion update(@RequestBody Calificacion score) {
        return score_service.update(score);
    }

    /**
     * Método para eliminar un puntaje de una reservación
     *
     * @param id identificador del puntaje de la reservación a eliminar
     * @return booleano de confirmación
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return score_service.delete(id);
    }
}
