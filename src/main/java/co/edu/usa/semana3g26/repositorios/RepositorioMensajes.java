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
 *
 * @author HeerJHobby
 */
@Repository
public class RepositorioMensajes {
      @Autowired
    private InterfaceMensajes crud3;
    public List<Mensajes> getAll(){
        return (List<Mensajes>) crud3.findAll();
    }
    public Optional<Mensajes> getMessage(int id){
        return crud3.findById(id);
    }

    public Mensajes save(Mensajes message){
        return crud3.save(message);
    }
    public void delete(Mensajes message){
        crud3.delete(message);
    }
}
