/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios;

import co.edu.usa.semana3g26.modelo.Reservaciones;
import co.edu.usa.semana3g26.repositorios.crud.InterfaceReservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase Repository RepositorioReservaciones
 *
 * @version 1.2
 * @author Jhoan Villa G26 C3
 */
@Repository
public class RepositorioReservaciones {

    /**
     * Variable que representa la interfaz CrudRepository de la reservación
     */
    @Autowired
    private InterfaceReservaciones crud_repository;

    /**
     * Método para obtener el listado de reservaciones existentes
     *
     * @return listado de reservaciones
     */
    public List<Reservaciones> getAll() {
        return (List<Reservaciones>) crud_repository.findAll();
    }

    /**
     * Método para obtener una reservación específica por el identificador
     *
     * @param id identificador de la reservación
     * @return reservación
     */
    public Optional<Reservaciones> getById(int id) {
        return crud_repository.findById(id);
    }

    /**
     * Método para crear y/o actualizar una reservación
     *
     * @param reservaciones datos de la reservación a crear y/o actualizar
     * @return reservación
     */
    public Reservaciones save(Reservaciones reservaciones) {
        return crud_repository.save(reservaciones);
    }

    /**
     * Método para eliminar una reservación
     *
     * @param reservaciones datos de la reservación a eliminar
     */
    public void delete(Reservaciones reservaciones) {
        crud_repository.delete(reservaciones);
    }
}
