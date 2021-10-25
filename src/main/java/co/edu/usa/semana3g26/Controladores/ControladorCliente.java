/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.Controladores;

import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.servicios.ServiciosCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase Controller Cliente
 *
 * @version 1.3
 * @author Lorena Nossa
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorCliente {
    
    /**
     * Variable que representa el servicio del cliente
     */
     @Autowired
    private ServiciosCliente servicio;
  
    /**
     * Método para obtener el listado de clientes existentes
     *
     * @return listado de clientes en formato JSON
     */
    @GetMapping("/all")
    public List<Cliente> getClients(){
        return servicio.getAll();
    }

     /**
     * Método para obtener una cliente específico por la identificador
     *
     * @paramid identificador del cliente
     * @return cliente
     */
    @GetMapping("/{id}")
    public Optional<Cliente> getClient(@PathVariable("id") int clientId) {
        return servicio.getClient(clientId);
    }

    /**
     * Método para crear una cliente
     *
     * @param client datos del cliente a crear en formato JSON
     * @return cliente en formato JSON
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente client) {
        return servicio.save(client);
    }
    
    /**
     * Método para actualizar una cliente
     *
     * @param client datos del cliente a actualizar en formato JSON
     * @return cliente en formato JSON
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente client) {
        return servicio.update(client);
    }

    /**
     * Método para borrar una cliente
     *
     * @paramid dato del  id del cleinte a borrar por ID formato JSON
     * @return cliente en formato JSON
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return servicio.deleteClient(clientId);
    }
}


