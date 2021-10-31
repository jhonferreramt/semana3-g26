/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.modelo.personalizado;

/**
 * Clase Modelo Personalizado CanceladoCompletado
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
public class CanceladoCompletado {

    /**
     * Variable que representa el total de reservaciones completadas
     */
    private Long completed;

    /**
     * Variable que representa el total de reservaciones canceladas
     */
    private Long cancelled;

    /**
     * Método constructor de la clase personalizada
     *
     * @param completed representa el total de reservaciones completadas
     * @param cancelled representa el total de reservaciones canceladas
     */
    public CanceladoCompletado(Long completed, Long cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    /**
     * Método para obtener el total de reservaciones completadas
     *
     * @return total de reservaciones completadas
     */
    public Long getCompleted() {
        return completed;
    }

    /**
     * Método para ingresar y cambiar el valor del total de reservaciones
     * completadas
     *
     * @param completed total de reservaciones completadas
     */
    public void setCompleted(Long completed) {
        this.completed = completed;
    }

    /**
     * Método para obtener el total de reservaciones canceladas
     *
     * @return total de reservaciones canceladas
     */
    public Long getCancelled() {
        return cancelled;
    }

    /**
     * Método para ingresar y cambiar el valor del total de reservaciones
     * canceladas
     *
     * @param cancelled total de reservaciones canceladas
     */
    public void setCancelled(Long cancelled) {
        this.cancelled = cancelled;
    }
}
