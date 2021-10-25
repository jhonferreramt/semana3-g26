/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios.crud;

import co.edu.usa.semana3g26.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz Repository InterfaceCliente
 *
 * @version 1.2
 * @author Lorena Nossa G26 C3
 */
public interface InterfaceCliente extends CrudRepository<Cliente,Integer> {
    
}

