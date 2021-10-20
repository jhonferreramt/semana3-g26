/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Calificacion;
import co.edu.usa.semana3g26.repositorios.RepositorioCalificacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase Service ServiciosCalificacion
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
@Service
public class ServiciosCalificacion {

    /**
     * Variable que representa la clase Repository del puntaje de la reservación
     */
    @Autowired
    private RepositorioCalificacion score_repository;

    /**
     * Método para obtener el listado de puntajes de reservaciones existentes
     *
     * @return listado de puntajes de reservaciones
     */
    public List<Calificacion> getAll() {
        return score_repository.getAll();
    }

    /**
     * Método para obtener un puntaje de una reservación específica por el
     * identificador
     *
     * @param id identificador del puntaje de la reservación
     * @return puntaje de la reservación
     */
    public Calificacion getById(int id) {
        Optional<Calificacion> score = score_repository.getById(id);
        return score.orElse(new Calificacion());
    }

    /**
     * Método para crear y/o actualizar un puntaje de una reservación
     *
     * @param score datos del puntaje de la reservación a crear y/o actualizar
     * @return puntaje de la reservación
     */
    public Calificacion save(Calificacion score) {
        return score_repository.save(score);
    }
}
