/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clase Calificacion
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
@Entity
@Table(name = "score")
public class Calificacion {

    /**
     * Variable que representa el identificador del puntaje de la reservación y
     * llave primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idScore;

    /**
     * Variable que representa el puntaje de la reservación
     */
    private Integer score;

    /**
     * Variable que representa el texto del mensaje del puntaje de la
     * reservación
     */
    @Column(name = "message", length = 250)
    private String message;

    /**
     * Variable que representa la reservación
     */
    @OneToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    @JsonIgnoreProperties("score")
    private Reservaciones reservation;

    /**
     * Método para obtener el identificador de un puntaje de una reservación
     *
     * @return identificador asociado al puntaje de la reservación
     */
    public Integer getIdScore() {
        return idScore;
    }

    /**
     * Método para ingresar y cambiar el valor del identificador de un puntaje
     * de una reservación
     *
     * @param idScore identificador asociado al puntaje de la reservación
     */
    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    /**
     * Método para obtener el puntaje de una reservación
     *
     * @return puntaje de la reservación
     */
    public Integer getScore() {
        return score;
    }

    /**
     * Método para ingresar y cambiar el valor del puntaje de una reservación
     *
     * @param score puntaje de la reservación
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Método para obtener el texto de un mensaje de un puntaje de una
     * reservación
     *
     * @return texto del mensaje del puntaje de la reservación
     */
    public String getMessage() {
        return message;
    }

    /**
     * Método para ingresar y cambiar el valor del texto de un mensaje de un
     * puntaje de una reservación
     *
     * @param message texto del mensaje del puntaje de la reservación
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Método para obtener la reservación asociada al puntaje
     *
     * @return reservación asociada al puntaje
     */
    public Reservaciones getReservation() {
        return reservation;
    }

    /**
     * Método para ingresar y cambiar el valor de la reservación asociada al
     * puntaje
     *
     * @param reservation reservación asociada al puntaje
     */
    public void setReservation(Reservaciones reservation) {
        this.reservation = reservation;
    }
}
