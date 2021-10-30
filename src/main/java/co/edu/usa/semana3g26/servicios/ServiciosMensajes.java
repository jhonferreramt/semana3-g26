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
 *
 * @author HeerJHobby
 */
@Service
public class ServiciosMensajes {
    @Autowired
    private RepositorioMensajes metodosCrud;

    public List<Mensajes> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Mensajes> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

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

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
