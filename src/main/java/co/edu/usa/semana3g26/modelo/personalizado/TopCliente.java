/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.modelo.personalizado;

import co.edu.usa.semana3g26.modelo.Cliente;

/**
 * Clase Modelo Personalizado TopCliente
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
public class TopCliente {

    /**
     * Variable que representa el total de reservaciones del cliente
     */
    private Long total;

    /**
     * Variable que representa el cliente de las reservaciones
     */
    private Cliente client;

    /**
     * Método constructor de la clase personalizada
     *
     * @param total representa el total de reservaciones del cliente
     * @param client representa el cliente de las reservaciones
     */
    public TopCliente(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    /**
     * Método para obtener el total de reservaciones del cliente
     *
     * @return total de reservaciones del cliente
     */
    public Long getTotal() {
        return total;
    }

    /**
     * Método para ingresar y cambiar el valor del total de reservaciones del
     * cliente
     *
     * @param total total de reservaciones del cliente
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * Método para obtener el cliente de las reservaciones
     *
     * @return cliente de las reservaciones
     */
    public Cliente getClient() {
        return client;
    }

    /**
     * Método para ingresar y cambiar el valor del cliente de las reservaciones
     *
     * @param client cliente de las reservaciones
     */
    public void setClient(Cliente client) {
        this.client = client;
    }
}
