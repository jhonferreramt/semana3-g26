/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Reservaciones;
import co.edu.usa.semana3g26.repositorios.RepositorioReservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase Service ServiciosReservaciones
 *
 * @version 1.2
 * @author Jhoan Villa G26 C3
 */
@Service
public class ServiciosReservaciones {

    /**
     * Variable que representa la clase Repository de la reservación
     */
    @Autowired
    private RepositorioReservaciones reservation_repository;

    /**
     * Método para obtener el listado de reservaciones existentes
     *
     * @return listado de reservaciones
     */
    public List<Reservaciones> getAll() {
        return reservation_repository.getAll();
    }

    /**
     * Método para obtener una reservación específica por el identificador
     *
     * @param id identificador de la reservación
     * @return reservación
     */
    public Reservaciones getById(int id) {
        Optional<Reservaciones> reservation = reservation_repository.getById(id);
        return reservation.orElse(new Reservaciones());
    }

    /**
     * Método para crear y/o actualizar una reservación
     *
     * @param reservation datos de la reservación a crear y/o actualizar
     * @return reservación
     */
    public Reservaciones save(Reservaciones reservation) {
        return reservation_repository.save(reservation);
    }
}
