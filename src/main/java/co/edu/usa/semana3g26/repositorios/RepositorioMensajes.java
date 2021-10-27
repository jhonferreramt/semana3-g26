/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios;

import co.edu.usa.semana3g26.modelo.Mensajes;
import co.edu.usa.semana3g26.repositorios.crud.InterfaceMensajes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * version 1.0 
 * Claase Repositorio para Mensajes 
 * @author Jean James Romero Aguirre
 * Grupo G-26
 */

@Repository
public class RepositorioMensajes {
    /**
     * Variable Crud Repository de clase Mensajes
     */
      @Autowired
    private InterfaceMensajes crud3;
      
      /**
     * Método que obtiene listado de mensajes
     *
     * @return listado mensajes
     */
    public List<Mensajes> getAll(){
        return (List<Mensajes>) crud3.findAll();
    }
    /**
     * Método que obtiene una mensaje por su identificador
     *
     * @param id de mensaje
     * @return envio consulta por id a RepositorioCrud3
     */
    public Optional<Mensajes> getMessage(int id){
        return crud3.findById(id);
    }

    /**
     * Método para actualizar o Guardar mensajes
     *
     * @param ortopedics
     * @return listado mensaje
     */
    public Mensajes save(Mensajes message){
        return crud3.save(message);
    }
    
    /**
     * Método para borrar mensajes
     *
     * @param ortopedics
     */
    public void delete(Mensajes message){
        crud3.delete(message);
    }
}
