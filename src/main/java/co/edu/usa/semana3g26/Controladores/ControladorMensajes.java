/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.Controladores;

import co.edu.usa.semana3g26.modelo.Mensajes;
import co.edu.usa.semana3g26.servicios.ServiciosMensajes;
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
 * version 1.0 
 * Claase Controlador para Mensajes Ruta general api
 * @author Jean James Romero Aguirre
 * Grupo G-26
 */

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorMensajes {
    
    /**
     * Variable con referencia a Servicio Mensaje
     */
     @Autowired
    private ServiciosMensajes servico;
    @GetMapping("/all")
    public List<Mensajes> getMessages(){
        return servico.getAll();
    }

    /**
     * Método obtener Listado Mensajes
     *
     * @return formato JSON con datos lista Mensajes
     */
    @GetMapping("/{id}")
    public Optional<Mensajes> getMessage(@PathVariable("id") int messageId) {
        return servico.getMessage(messageId);
    }

    /**
     * Método Guardar Mensaje
     *
     * @param mensaje
     * @return le retornamos a servicioMensaje el JSON para la instruccion
     * update
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes save(@RequestBody Mensajes message) {
        return servico.save(message);
    }
    
    /**
     * Método Crear Mensajes
     *
     * @param mensajes
     * @return le retornamos a servicioMensajes el JSON para la instgruccion
     * update
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes update(@RequestBody Mensajes message) {
        return servico.update(message);
    }

    
    /**
     * Método Borrar Mensajes
     *
     * @param mensajesId
     * @return le retornamos a servicioMensaje el JSON para la instruccion
     * delete
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return servico.deleteMessage(messageId);
    }
    
}

