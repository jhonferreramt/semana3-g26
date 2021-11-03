/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Administrativo
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
@Entity
@Table(name = "admin")
public class Administrativo implements Serializable {

    /**
     * Variable que representa el identificador del administrador y llave
     * primaria de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Variable que representa el correo electrónico del administrador
     */
    @Column(length = 45)
    private String email;

    /**
     * Variable que representa la contraseña del administrador
     */
    @Column(length = 45)
    private String password;

    /**
     * Variable que representa el nombre del administrador
     */
    @Column(length = 250)
    private String name;

    /**
     * Método para obtener el identificador de un administrador
     *
     * @return identificador asociado al administrador
     */
    public Integer getIdAdmin() {
        return id;
    }

    /**
     * Método para ingresar y cambiar el valor del identificador de un
     * administrador
     *
     * @param id identificador asociado al administrador
     */
    public void setIdAdmin(Integer id) {
        this.id = id;
    }

    /**
     * Método para obtener el correo electrónico de un administrador
     *
     * @return coreo electrónico del administrador
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método para ingresar y cambiar el valor del correo electrónico de un
     * administrador
     *
     * @param email correo electrónico del administrador
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método para obtener la contraseña de un administrador
     *
     * @return contraseña del administrador
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método para ingresar y cambiar el valor de la contraseña de un
     * administrador
     *
     * @param password contraseña del administrador
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método para obtener el nombre de un administrador
     *
     * @return nombre del administrador
     */
    public String getName() {
        return name;
    }

    /**
     * Método para ingresar y cambiar el valor del nombre de un administrador
     *
     * @param name nombre del administrador
     */
    public void setName(String name) {
        this.name = name;
    }
}
