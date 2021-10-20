/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repositorios;

import co.edu.usa.semana3g26.modelo.Administrativo;
import co.edu.usa.semana3g26.repositorios.crud.InterfaceAdministrativo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Clase Repository RepositorioAdministrativo
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
@Repository
public class RepositorioAdministrativo {

    /**
     * Variable que representa la interfaz CrudRepository del administrador
     */
    @Autowired
    private InterfaceAdministrativo admin_crud_repository;

    /**
     * Método para obtener el listado de administradores existentes
     *
     * @return listado de administradores
     */
    public List<Administrativo> getAll() {
        return (List<Administrativo>) admin_crud_repository.findAll();
    }

    /**
     * Método para obtener un administrador específico por el identificador
     *
     * @param id identificador del administrador
     * @return administrador
     */
    public Optional<Administrativo> getById(int id) {
        return admin_crud_repository.findById(id);
    }

    /**
     * Método para crear y/o actualizar un administrador
     *
     * @param admin datos del administrador a crear y/o actualizar
     * @return administrador
     */
    public Administrativo save(Administrativo admin) {
        return admin_crud_repository.save(admin);
    }

    /**
     * Método para eliminar un administrador
     *
     * @param admin datos del administrador a eliminar
     */
    public void delete(Administrativo admin) {
        admin_crud_repository.delete(admin);
    }
}
