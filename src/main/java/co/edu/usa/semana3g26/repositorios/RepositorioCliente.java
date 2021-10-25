/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios;

import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.repositorios.crud.InterfaceCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase Repository RepositorioCliente
 *
 * @version 1.2
 * @author Lorena Nossa G26 C3
 */
@Repository
public class RepositorioCliente {
     /**
     * Variable que representa la interfaz CrudRepository del Cliente
     */
      @Autowired
    private InterfaceCliente crud1;

    /**
     * Método para obtener el listado de clientes existentes
     *
     * @return listado de reservaciones
     */
    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();
    }
    
    /**
     * Método para obtener un cliente específica por el identificador
     *
     * @param id identificador del cliente
     * @return client
     */
    public Optional<Cliente> getCliente(int id){
        return crud1.findById(id);
    }

    /**
     * Método para crear y/o actualizar una cliente
     *
     * @param cliente datos del cliente a crear y/o actualizar
     * @return client
     */
    public Cliente save(Cliente cliente){
        return crud1.save(cliente);
    }
    
    /**
     * Método para eliminar un cliente
     *
     * @param cliente datos del cliente a eliminar
     */
    public void delete(Cliente cliente){
        crud1.delete(cliente);
    }
}
