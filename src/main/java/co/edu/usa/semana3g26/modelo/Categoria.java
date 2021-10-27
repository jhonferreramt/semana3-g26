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
 * version 1.0 
 * Clase modelo Categoria
 * @author Isaias Perez Ramirez
 * Grupo G-26
 */


@Entity
@Table(name = "category")
public class Categoria implements Serializable {
/**
     * Parametros de clase llave primaria
     *
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    /**
     * Variable identificador Categorias
     */
    private Integer id;
    
    /**
     * Variable Nombre de la Categoria
     */
    private String name;
    
    /**
     * Variable Descripción de la Categoria
     */
    private String description;

    
    /**
     * Objeto ortopedics que representa lista de categorias y sus respectivas
     * relaciones con las tablas ortopedics para creacion de JSON
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Ortesis> ortopedics;
    
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ortesis> getOrtopedics() {
        return ortopedics;
    }

    public void setOrtopedics(List<Ortesis> ortopedics) {
        this.ortopedics = ortopedics;
    }

}
