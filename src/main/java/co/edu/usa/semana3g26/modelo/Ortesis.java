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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * version 1.0 
 * Claase modelo Ortesis
 * @author Jhon Ferney Herrera 
 * Grupo G-26
 */
@Entity
@Table(name = "ortopedics")
public class Ortesis implements Serializable {

    /**
     * Parametros de clase llave primaria
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Variable identificador Ortesis
     */
    private Integer id;
    /**
     * Variable Nombre de la Ortesis
     */
    private String name;
    /**
     * Variable Marca de la Ortesis
     */
    private String brand;
    /**
     * Variable Año de la Ortesis
     */
    private Integer year;
    /**
     * Variable Descripcion de la Ortesis
     */
    private String description;
    /**
     * Objeto messages que representa lista de mensajes y sus respectivas
     * relaciones con las tablas ortopedics para creacion de JSON
     */

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("ortopedics")
    private Categoria category;
    /**
     * Objeto messages que representa lista de mensajes y sus respectivas
     * relaciones con las tablas ortopedic y client para creacion de JSON
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "client"})
    private List<Mensajes> messages;
    /**
     * Objeto reservations que representa lista de Reservaciones y sus
     * respectivas relaciones con las tablas ortopedic y client para creacion de
     * JSON
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "client"})
    private List<Reservaciones> reservations;

    /**
     * Métodos Getter And Setter
     *
     *
     * @return objetos que retornan los valores de cada metodo
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensajes> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensajes> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
}
