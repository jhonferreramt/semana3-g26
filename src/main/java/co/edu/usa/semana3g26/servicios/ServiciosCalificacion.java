/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Calificacion;
import co.edu.usa.semana3g26.modelo.Reservaciones;
import co.edu.usa.semana3g26.repositorios.RepositorioCalificacion;
import co.edu.usa.semana3g26.repositorios.RepositorioReservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase Service ServiciosCalificacion
 *
 * @version 1.1
 * @author Jhoan Villa G26 C3
 */
@Service
public class ServiciosCalificacion {

    /**
     * Variable que representa la clase Repository de la reservación
     */
    @Autowired
    private RepositorioReservaciones reservation_repository;

    /**
     * Variable que representa la clase Repository del puntaje de la reservación
     */
    @Autowired
    private RepositorioCalificacion score_repository;

    /**
     * Método para validar los datos de un puntaje de una reservación
     *
     * @param score datos del puntaje de la reservación a validar
     * @return indicador si los datos son válidos o no
     */
    protected boolean validateData(Calificacion score) {

        if (score.getMessage().length() > 250 && score.getMessage() != null) {
            return false;
        }

        if (score.getScore() > 5
                && score.getScore() != null) {
            return false;
        }

        if (score.getScore() < 0
                && score.getScore() != null) {
            return false;
        }

        Optional<Reservaciones> reservacion_consultada = reservation_repository.
                getById(score.getReservation().getIdReservation());
        if (!reservacion_consultada.isPresent()
                || score.getReservation().getIdReservation() == null) {
            return false;
        }

        return true;
    }

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
     * Método para crear un puntaje de una reservación
     *
     * @param score datos del puntaje de la reservación a crear
     * @return puntaje de la reservación
     */
    public Calificacion save(Calificacion score) {
        if (validateData(score)) {
            if (score.getIdScore() == null) {
                return score_repository.save(score);
            } else {
                Optional<Calificacion> puntaje_aux = score_repository.getById(
                        score.getIdScore());
                if (puntaje_aux.isPresent()) {
                    return score;
                } else {
                    return score_repository.save(score);
                }
            }
        } else {
            return score;
        }
    }

    /**
     * Método para eliminar un puntaje de una reservación
     *
     * @param id identificador del puntaje de la reservación a eliminar
     * @return booleano de confirmación
     */
    public boolean delete(int id) {
        boolean del = score_repository.getById(id).map(score -> {
            score_repository.delete(score);
            return true;
        }).orElse(false);
        return del;
    }

    /**
     * Método para actualizar un puntaje de una reservación
     *
     * @param score datos del puntaje de la reservación a actualizar
     * @return puntaje de la reservación
     */
    public Calificacion update(Calificacion score) {
        if (score.getIdScore() != null) {
            Optional<Calificacion> puntaje_consultado = score_repository.
                    getById(score.getIdScore());
            if (puntaje_consultado.isPresent() && validateData(score)) {
                if (score.getScore() != null) {
                    puntaje_consultado.get().setScore(score.getScore());
                }

                if (score.getMessage() != null) {
                    puntaje_consultado.get().setMessage(score.getMessage());
                }

                if (score.getReservation() != null) {
                    puntaje_consultado.get().setReservation(score.
                            getReservation());
                }

                return score_repository.save(puntaje_consultado.get());
            }
        }
        return score;
    }
}
