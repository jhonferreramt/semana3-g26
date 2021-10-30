/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios;

import co.edu.usa.semana3g26.modelo.Categoria;
import co.edu.usa.semana3g26.repositorios.crud.InterfaceCategoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Claase Repositorio para Categoria
 * Version 1.0
 * @author Isaias Perez Ramirez 
 * Grupo G-26
 */
@Repository
public class RepositorioCategoria {
    
     /**
     * Variable Crud Repository de clase Categorias
     */
    @Autowired
    private InterfaceCategoria crud;
    
    /**
     * Método que obtiene listado de Categorias
     *
     * @return listado categoria
     */
    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }
    
     /**
     * Método que obtiene una categoria por su identificador
     *
     * @param id de categoria
     * @return envio consulta por id a RepositorioCrud2
     */
    public Optional<Categoria> getCategoria(int id){
        return crud.findById(id);
    }

    /**
     * Método para actualizar o Guardar categoria
     *
     * @param ortopedics
     * @return listado categoria
     */
    public Categoria save(Categoria Categoria){
        return crud.save(Categoria);
    }
    
    /**
     * Método para borrar categoria
     *
     * @param ortopedics
     */
    public void delete(Categoria Categoria){
       crud.delete(Categoria);
    }
}
