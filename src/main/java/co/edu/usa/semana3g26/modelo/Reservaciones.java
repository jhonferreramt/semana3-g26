/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Clase Reservaciones
 *
 * @version 1.2
 * @author Jhoan Villa G26 C3
 */
@Entity
@Table(name = "reservation")
public class Reservaciones implements Serializable  {

    /**
     * Variable que representa el identificador de la reservación y llave
     * primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idReservation;

    /**
     * Variable que representa la fecha de inicio de la reservación
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    /**
     * Variable que representa la fecha de fin de la reservación
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "devolution_date")
    private Date devolutionDate;

    /**
     * Variable que representa el estado de la reservación
     */    
    private String status = "created";

    /**
     * Variable que representa la fecha de creación de la reservación
     */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", columnDefinition = "timestamp default current_timestamp")
    @JsonIgnore
    private Date creationDate;

    /**
     * Variable que representa la órtesis de la reservación
     */
    @ManyToOne
    @JoinColumn(name = "orthesis_id", nullable = false)
    @JsonIgnoreProperties("reservations")
    private Ortesis ortopedic;

    /**
     * Variable que representa el cliente de la reservación
     */
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cliente client;

    /**
     * Variable que representa el puntaje de la reservación
     */

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    @JoinColumn(nullable = true)
    private Calificacion score;

    /**
     * Método para obtener el identificador de una reservación
     *
     * @return identificador asociado a la reservación
     */
    public Integer getIdReservation() {
        return idReservation;
    }

    /**
     * Método para ingresar y cambiar el valor del identificador de una
     * reservación
     *
     * @param idReservation identificador asociado a la reservación
     */
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    /**
     * Método para obtener la fecha de inicio de una reservación
     *
     * @return fecha de inicio de la reservación
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Método para ingresar y cambiar el valor de la fecha de inicio de una
     * reservación
     *
     * @param startDate fecha de inicio de la reservación
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Método para obtener la fecha de fin de una reservación
     *
     * @return fecha de fin de la reservación
     */
    public Date getDevolutionDate() {
        return devolutionDate;
    }

    /**
     * Método para ingresar y cambiar el valor de la fecha de fin de una
     * reservación
     *
     * @param devolutionDate fecha de fin de la reservación
     */
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    /**
     * Método para obtener el estado de una reservación
     *
     * @return estado de la reservación
     */
    public String getStatus() {
        return status;
    }

    /**
     * Método para ingresar y cambiar el valor del estado de una reservación
     *
     * @param status estado de la reservación
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Método para obtener la fecha de creación de una reservación
     *
     * @return fecha de creación de la reservación
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Método para ingresar y cambiar el valor de la fecha de creación de una
     * reservación
     *
     * @param creationDate fecha de creación de la reservación
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Método para obtener la órtesis de una reservación
     *
     * @return órtesis de la reservación
     */
    public Ortesis getOrtopedic() {
        return ortopedic;
    }

    /**
     * Método para ingresar y cambiar el valor de la órtesis de una reservación
     *
     * @param ortopedic órtesis de la reservación
     */
    public void setOrtopedic(Ortesis ortopedic) {
        this.ortopedic = ortopedic;
    }

    /**
     * Método para obtener el cliente de una reservación
     *
     * @return cliente de la reservación
     */
    public Cliente getClient() {
        return client;
    }

    /**
     * Método para ingresar y cambiar el valor del cliente de una reservación
     *
     * @param client cliente de la reservación
     */
    public void setClient(Cliente client) {
        this.client = client;
    }

    /**
     * Método para obtener el puntaje de una reservación
     *
     * @return puntaje de la reservación
     */
    public Calificacion getScore() {
        return score;
    }

    /**
     * Método para ingresar y cambiar el valor del puntaje de una reservación
     *
     * @param score puntaje de la reservación
     */
    public void setScore(Calificacion score) {
        this.score = score;
    }
}
