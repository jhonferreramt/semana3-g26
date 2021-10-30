/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios;

import co.edu.usa.semana3g26.modelo.Calificacion;
import co.edu.usa.semana3g26.repositorios.crud.InterfaceCalificacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase Repository RepositorioCalificacion
 *
 * @version 1.1
 * @author Jhoan Villa G26 C3
 */
@Repository
public class RepositorioCalificacion {

    /**
     * Variable que representa la interfaz CrudRepository del puntaje de la
     * reservación
     */
    @Autowired
    private InterfaceCalificacion reservation_crud_repository;

    /**
     * Método para obtener el listado de puntajes de reservaciones existentes
     *
     * @return listado de puntajes de reservaciones
     */
    public List<Calificacion> getAll() {
        return (List<Calificacion>) reservation_crud_repository.findAll();
    }

    /**
     * Método para obtener un puntaje de una reservación específica por el
     * identificador
     *
     * @param id identificador del puntaje de la reservación
     * @return puntaje de la reservación
     */
    public Optional<Calificacion> getById(int id) {
        return reservation_crud_repository.findById(id);
    }

    /**
     * Método para crear y/o actualizar un puntaje de una reservación
     *
     * @param reservation datos del puntaje de la reservación a crear y/o
     * actualizar
     * @return puntaje de la reservación
     */
    public Calificacion save(Calificacion reservation) {
        return reservation_crud_repository.save(reservation);
    }

    /**
     * Método para eliminar un puntaje de una reservación
     *
     * @param reservation datos del puntaje de la reservación a eliminar
     */
    public void delete(Calificacion reservation) {
        reservation_crud_repository.delete(reservation);
    }
}
