/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.modelo.Reservaciones;
import co.edu.usa.semana3g26.modelo.personalizado.CanceladoCompletado;
import co.edu.usa.semana3g26.modelo.personalizado.TopCliente;
import co.edu.usa.semana3g26.repositorios.RepositorioCliente;
import co.edu.usa.semana3g26.repositorios.RepositorioOrtesis;
import co.edu.usa.semana3g26.repositorios.RepositorioReservaciones;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase Service ServiciosReservaciones
 *
 * @version 1.3
 * @author Jhoan Villa G26 C3
 */
@Service
public class ServiciosReservaciones {

    /**
     * Variable que representa la clase Repository del cliente
     */
    @Autowired
    private RepositorioCliente clientRepo;

    /**
     * Variable que representa la clase Repository de la órtesis
     */
    @Autowired
    private RepositorioOrtesis orthesisRepo;

    /**
     * Variable que representa la clase Repository de la reservación
     */
    @Autowired
    private RepositorioReservaciones reservationRepo;

    /**
     * Método para validar los datos de una reservación
     *
     * @param reservation datos de la reservación a validar
     * @return indicador si los datos son válidos o no
     */
    protected boolean validateData(Reservaciones reservation) {

        Optional<Cliente> clienteConsul = clientRepo.getCliente(
                reservation.getClient().getIdClient());
        if (!clienteConsul.isPresent()
                || reservation.getClient().getIdClient() == null) {
            return false;
        }

        Optional<Ortesis> ortesisConsul = orthesisRepo.getOrtesis(
                reservation.getOrtopedic().getId());
        if (!ortesisConsul.isPresent()
                || reservation.getOrtopedic().getId() == null) {
            return false;
        }

        if (reservation.getStatus() != null
                && !"created".equals(reservation.getStatus())
                && !"programmed".equals(reservation.getStatus())
                && !"cancelled".equals(reservation.getStatus())
                && !"completed".equals(reservation.getStatus())) {
            return false;
        }

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        Date devolutionDate = new Date();

        try {
            startDate = parser.parse(parser.format(
                    reservation.getStartDate()));
            devolutionDate = parser.parse(parser.format(
                    reservation.getDevolutionDate()));

            if (!startDate.equals(devolutionDate)
                    && !startDate.before(devolutionDate)) {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     * Método para obtener el listado de reservaciones existentes
     *
     * @return listado de reservaciones
     */
    public List<Reservaciones> getAll() {
        return reservationRepo.getAll();
    }

    /**
     * Método para obtener el listado de reservaciones cuya fecha de inicio se
     * encuentre después de una fecha 1 y antes de una fecha 2
     *
     * @param dateOne fecha de inicio menor
     * @param dateTwo fecha de inicio mayor
     * @return listado de reservaciones entre las fechas de inicio dadas
     */
    public List<Reservaciones> getByPeriod(String dateOne, String dateTwo) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateA = new Date();
        Date startDateB = new Date();
        try {
            startDateA = parser.parse(dateOne);
            startDateB = parser.parse(dateTwo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (startDateA.before(startDateB)) {
            return reservationRepo.getByPeriod(startDateA,
                    startDateB);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Método para obtener una reservación específica por el identificador
     *
     * @param idReser identificador de la reservación
     * @return reservación
     */
    public Reservaciones getById(int idReser) {
        Optional<Reservaciones> reservation = reservationRepo.getById(idReser);
        return reservation.orElse(new Reservaciones());
    }

    /**
     * Método para obtener el total de reservaciones en estado de canceladas y/o
     * completas
     *
     * @return total de reservaciones en dichos estados
     */
    public CanceladoCompletado getCancelledCompleted() {
        return reservationRepo.getCancelledCompleted();
    }

    /**
     * Método para obtener el listado de usuarios con la cantidad reservas
     * completas
     *
     * @return lista de usuarios con la cantidad reservas completas
     */
    public List<TopCliente> getTopClient() {
        return reservationRepo.getTopClient();
    }

    /**
     * Método para crear una reservación
     *
     * @param reservation datos de la reservación a crear
     * @return reservación
     */
    public Reservaciones save(Reservaciones reservation) {
        if (validateData(reservation)) {
            if (reservation.getIdReservation() == null) {
                return reservationRepo.save(reservation);
            } else {
                Optional<Reservaciones> reservacionAux = reservationRepo.
                        getById(reservation.getIdReservation());
                if (reservacionAux.isPresent()) {
                    return reservation;
                } else {
                    return reservationRepo.save(reservation);
                }
            }
        } else {
            return reservation;
        }
    }

    /**
     * Método para eliminar una reservación
     *
     * @param idReser identificador de la reservación a eliminar
     * @return booleano de confirmación
     */
    public boolean delete(int idReser) {
        return reservationRepo.getById(idReser).map(reservation -> {
            reservationRepo.delete(reservation);
            return true;
        }).orElse(false);
    }

    /**
     * Método para actualizar una reservación
     *
     * @param reservation datos de la reservación a actualizar
     * @return reservación
     */
    public Reservaciones update(Reservaciones reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservaciones> reservacionConsul
                    = reservationRepo.getById(reservation.
                            getIdReservation());
            if (reservacionConsul.isPresent()
                    && validateData(reservation)) {
                if (reservation.getClient() != null) {
                    reservacionConsul.get().setClient(reservation.
                            getClient());
                }

                if (reservation.getOrtopedic() != null) {
                    reservacionConsul.get().setOrtopedic(reservation.
                            getOrtopedic());
                }

                if (reservation.getStartDate() != null) {
                    reservacionConsul.get().setStartDate(reservation.
                            getStartDate());
                }

                if (reservation.getDevolutionDate() != null) {
                    reservacionConsul.get().setDevolutionDate(reservation.
                            getDevolutionDate());
                }

                if (reservation.getStatus() != null) {
                    reservacionConsul.get().setStatus(reservation.
                            getStatus());
                }

                return reservationRepo.save(reservacionConsul.
                        get());
            }
        }
        return reservation;
    }
}
