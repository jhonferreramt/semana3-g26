/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * version 1.0 
 * Claase Modelo para Mensajes 
 * @author Jean James Romero Aguirre
 * Grupo G-26
 */

@Entity
@Table(name = "message")
public class Mensajes implements Serializable {
    
    /**
     * Parametros de clase llave primaria
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Variable identificador Mensajes
     */
    private Integer idMessage;
    private String messageText;

    /**
     * Objeto ortopedic que representa lista de mensajes y sus respectivas
     * relaciones con las tablas ortopedic y client para creacion de JSON
     */
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Ortesis ortopedic;

    /**
     * Objeto client que representa lista de Reservaciones y sus
     * respectivas relaciones con las tablas ortopedic y client para creacion de
     * JSON
     */
    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Cliente client;

    
    /**
     * Métodos Getter And Setter
     *
     *
     * @return objetos que retornan los valores de cada metodo
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Ortesis getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortesis ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
}
