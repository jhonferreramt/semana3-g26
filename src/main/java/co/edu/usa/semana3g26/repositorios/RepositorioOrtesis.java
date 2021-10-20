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
    private InterfaceOrtesis crud;

    public List<Ortesis> getAll(){
        return (List<Ortesis>) crud.findAll();
    }

    public Optional<Ortesis> getBike(int id){
        return crud.findById(id);
    }

    public Ortesis save(Ortesis ortesis){
        return crud.save(ortesis);
    }
    public void delete(Ortesis ortesis){
        crud.delete(ortesis);
    }

    public Optional<Ortesis> getOrtesis(int ortesisId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Optional<Ortesis> get(int ortesisId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
