/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Mensajes;
import co.edu.usa.semana3g26.repositorios.RepositorioMensajes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * version 1.0 
 * Claase Servicios para Ortesis
 * @author Jean James Romero Aguirre
 * Grupo G-26
 */

@Service
public class ServiciosMensajes {
    /**
    * Variable que envia datos a repositorioCrud Ortesis
    */
    
    @Autowired
    private RepositorioMensajes metodosCrud;
    
    /**
     * Método para obtener lista de Mensajes
     *
     * @return listado obtenido
     */
    public List<Mensajes> getAll(){
        return metodosCrud.getAll();
    }
    
/**
     * Método para obtener Mnesajes por id
     *
     * @param mensajesId
     * @return mensajes obtenida
     */
    public Optional<Mensajes> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    /**
     * Método para guardar mensajes
     *
     * @param mensajes
     * @return listado obtenido
     */
    public Mensajes save(Mensajes message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensajes> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isPresent()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

     /**
     * Método optional que valida la informcion traida para actualizar
     *
     * @param mensajes
     * @return listado obtenido
     */
    public Mensajes update(Mensajes message){
        if(message.getIdMessage()!=null){
            Optional<Mensajes> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isPresent()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    /**
     * Método para eliminar un mensajes
     *
     * @param mensajesId
     * @return listado obtenido
     */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
