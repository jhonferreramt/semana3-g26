/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Categoria;
import co.edu.usa.semana3g26.repositorios.RepositorioCategoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * version 1.0 Claase Servicios para Categorias
 *
 * @author Isaias Perez Ramirez 
 * Grupo G-26
 */
@Service
public class ServiciosCategoria {
    
    /**
    * Variable que envia datos a repositorioCrud Categoria
    */
     @Autowired
    private RepositorioCategoria metodosCrud;

     /**
     * Método para obtener lista de Categoria
     *
     * @return listado obtenido
     */
    public List<Categoria> getAll() {
        return metodosCrud.getAll();
    }

     /**
     * Método para obtener Categoria por id
     *
     * @param categoriaId
     * @return categoria obtenida
     */
    public Optional<Categoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    /**
     * Método para guardar categoria
     *
     * @param categoria
     * @return listado obtenido
     */
    public Categoria save(Categoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<Categoria> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isPresent()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    /**
     * Método optional que valida la informcion traida para actualizar
     *
     * @param categoria
     * @return listado obtenido
     */
    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isPresent()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    
    /**
     * Método para eliminar una Categoria
     *
     * @param categoriaId
     * @return listado obtenido
     */
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}
