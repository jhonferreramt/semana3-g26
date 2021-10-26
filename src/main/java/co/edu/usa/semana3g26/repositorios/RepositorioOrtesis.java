/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios;

import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.repositorios.crud.InterfaceOrtesis;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Claase Repositorio para Ortesis
 * Version 1.0
 * @author Jhon Ferney Herrera 
 * Grupo G-26
 */
@Repository
public class RepositorioOrtesis {

    /**
     * Variable Crud Repository de clase Ortesis
     */
    @Autowired
    private InterfaceOrtesis crud2;

    /**
     * Método que obtiene listado de Ortesis
     *
     * @return listado ortesis
     */
    public List<Ortesis> getAll() {
        return (List<Ortesis>) crud2.findAll();
    }

    /**
     * Método que obtiene una ortesis por su identificador
     *
     * @param id de ortesis
     * @return envio consulta por id a RepositorioCrud2
     */
    public Optional<Ortesis> getOrtesis(int id) {
        return crud2.findById(id);
    }

    /**
     * Método para actualizar o Guardar ortesis
     *
     * @param ortopedics
     * @return listado ortesis
     */
    public Ortesis save(Ortesis ortopedics) {
        return crud2.save(ortopedics);
    }

    /**
     * Método para borrar ortesis
     *
     * @param ortopedics
     */
    public void delete(Ortesis ortopedics) {
        crud2.delete(ortopedics);
    }

}
