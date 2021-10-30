/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios.crud;

import co.edu.usa.semana3g26.modelo.Reservaciones;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz Repository InterfaceReservaciones
 *
 * @version 1.2
 * @author Jhoan Villa G26 C3
 */
public interface InterfaceReservaciones extends CrudRepository<Reservaciones, Integer> {

    /**
     * Método para obtener el listado de reservaciones cuya fecha de inicio se
     * encuentre después de una fecha 1 y antes de una fecha 2
     *
     * @param date_one fecha de inicio menor
     * @param date_two fecha de inicio mayor
     * @return listado de reservaciones entre las fechas de inicio dadas
     */
    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(
            Date date_one, Date date_two);

}
