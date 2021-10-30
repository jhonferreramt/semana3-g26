/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.repositorios.RepositorioCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase Service ServiciosCliente
 *
 * @version 1.2
 * @author Lorena Nossa G26 C3
 */
@Service
public class ServiciosCliente {
    /**
     * Variable que representa la clase Repository del Cliente
     */
       @Autowired
     private RepositorioCliente metodosCrud;
     
     /**
     * Método para obtener el listado de reservaciones cliente
     *
     * @return listado de cliente
     */
     public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
     
    /**
     * Método para obtener un cliente específica por el identificador
     *
     * @param clientId identificador del cliente
     * @return clienteId
     */
      public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }
      
         /**
     * Método para crear y/o actualizar un cliente
     *
     * @param client datos de la reservación a crear y/o actualizar
     * @return client
     */
    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(e.isPresent()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }

       /**
     * Método para actualizar una reservación
     *
     * @param client datos del client actualizar
     * @return reservación
     */
    public Cliente update(Cliente client){
        if(client.getIdClient()!=null){
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(e.isPresent()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

       /**
     * Método para borrar un cliente
     *
     * @param clientId datos de la reservación a crear y/o actualizar
     * @return reservación
     */
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
