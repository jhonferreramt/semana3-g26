/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase Cliente
 *
 * @version 1.2
 * @author Lorena Nossa G26 C3
 */
@Entity
@Table(name = "client")
public class Cliente implements Serializable {

    /**
     * Variable que representa el identificador de del cliente y llave
     * primaria de la tabla, variables como email, password, name y age del cliente 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;
    
    /**
     * Variable que representa relación entre cliente y mensaje
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Mensajes> messages;
    
    /**
     * Variable que representa relación entre cliente y reservación
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    public List<Reservaciones> reservations;

    /**
     * Método para obtener el identificador de un cliente
     *
     * @return idClient asociado al cliente
     */
    public Integer getIdClient() {
        return idClient;
    }
    
    /**
     * Método para ingresar y cambiar el valor del identificador de un
     * cliente
     *
     * @param idClient identificador asociado al cliente
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * Método para obtener el email de un cliente
     *
     * @return email asociado al cliente
     */
    public String getEmail() {
        return email;
    }

     /**
     * Método para ingresar y cambiar el valor del email de un
     * cliente
     *
     * @param email email asociado al cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Método para obtener la contraseña de un cliente
     *
     * @return passwprd asociado al cliente
     */
    public String getPassword() {
        return password;
    }

     /**
     * Método para ingresar y cambiar el valor de la contraseña de un
     * cliente
     *
     * @param password contraseña asociado al cliente
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método para obtener el nombre de un cliente
     *
     * @return name asociado al cliente
     */
    public String getName() {
        return name;
    }

     /**
     * Método para ingresar y cambiar el valor del nombre de un
     * cliente
     *
     * @param name nombre asociado al cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método para obtener la edad de un cliente
     *
     * @return age asociada al cliente
     */
    public Integer getAge() {
        return age;
    }

     /**
     * Método para ingresar y cambiar el valor de la edad de un
     * cliente
     *
     * @param age edad asociada al cliente
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Método para obtener la lista de mensajes de un cliente
     *
     * @return messages asociados al cliente
     */
    public List<Mensajes> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensajes> messages) {
        this.messages = messages;
    }

    /**
     * Método para obtener la reservación de un cliente
     *
     * @return reservations asociada al cliente
     */
    public List<Reservaciones> getReservations() {
        return reservations;
    }

     /**
     * Método para ingresar y cambiar el valor de la reservación de un
     * cliente
     *
     * @param reservations dato de reservación
     */
    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }

}
