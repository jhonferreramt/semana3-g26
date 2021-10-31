/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.Controladores;

import co.edu.usa.semana3g26.modelo.Reservaciones;
import co.edu.usa.semana3g26.modelo.personalizado.CanceladoCompletado;
import co.edu.usa.semana3g26.modelo.personalizado.TopCliente;
import co.edu.usa.semana3g26.servicios.ServiciosReservaciones;
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
 * Clase Controller ControladorReservaciones
 *
 * @version 1.3
 * @author Jhoan Villa G26 C3
 */
@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControladorReservaciones {

    /**
     * Variable que representa el servicio de la reservación
     */
    @Autowired
    private ServiciosReservaciones reservation_service;

    /**
     * Método para obtener el listado de reservaciones existentes
     *
     * @return listado de reservaciones en formato JSON
     */
    @GetMapping("/all")
    public List<Reservaciones> getAll() {
        return (List<Reservaciones>) reservation_service.getAll();
    }

    /**
     * Método para obtener el listado de reservaciones cuya fecha de inicio se
     * encuentre después de una fecha 1 y antes de una fecha 2
     *
     * @param date_one fecha de inicio menor
     * @param date_two fecha de inicio mayor
     * @return listado de reservaciones entre las fechas de inicio dadas
     */
    @GetMapping("/report/{dateOne}/{dateTwo}")
    public List<Reservaciones> getByPeriod(
            @PathVariable("dateOne") String date_one,
            @PathVariable("dateTwo") String date_two) {
        return reservation_service.getByPeriod(date_one, date_two);
    }

    /**
     * Método para obtener una reservación específica por el identificador
     *
     * @param id identificador de la reservación
     * @return reservación
     */
    @GetMapping("/{id}")
    public Reservaciones getById(@PathVariable("id") int id) {
        return reservation_service.getById(id);
    }

    /**
     * Método para obtener el total de reservaciones en estado de canceladas y/o
     * completas
     *
     * @return total de reservaciones en dichos estados
     */
    @GetMapping("/report-status")
    public CanceladoCompletado getCancelledCompleted() {
        return reservation_service.getCancelledCompleted();
    }

    /**
     * Método para obtener el listado de usuarios con la cantidad reservas
     * completas
     *
     * @return lista de usuarios con la cantidad reservas completas
     */
    @GetMapping("/report-clients")
    public List<TopCliente> getTopClient() {
        return reservation_service.getTopClient();
    }

    /**
     * Método para crear una reservación
     *
     * @param reservation datos de la reservación a crear en formato JSON
     * @return reservación en formato JSON
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return reservation_service.save(reservation);
    }

    /**
     * Método para modificar una reservación
     *
     * @param reservation datos de la reservación a modificar en formato JSON
     * @return reservación en formato JSON
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return reservation_service.update(reservation);
    }

    /**
     * Método para eliminar una reservación
     *
     * @param id identificador de la reservación a eliminar
     * @return booleano de confirmación
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return reservation_service.delete(id);
    }
}
