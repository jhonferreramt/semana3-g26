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
 *
 * @author HeerJHobby
 */
@Repository
public class RepositorioOrtesis {
    
    @Autowired
    private InterfaceOrtesis crud2;

    public List<Ortesis> getAll(){
        return (List<Ortesis>) crud2.findAll();
    }

    public Optional<Ortesis> getOrtesis(int id){
        return crud2.findById(id);
    }

    public Ortesis save(Ortesis ortopedics){
        return crud2.save(ortopedics);
    }
    public void delete(Ortesis ortopedics){
        crud2.delete(ortopedics);
    }

    
}