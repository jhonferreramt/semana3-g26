/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Administrativo;
import co.edu.usa.semana3g26.repositorios.RepositorioAdministrativo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase Service ServiciosAdministrativo
 *
 * @version 1.0
 * @author Jhoan Villa G26 C3
 */
@Service
public class ServiciosAdministrativo {

    /**
     * Variable que representa la clase Repository del administrador
     */
    @Autowired
    private RepositorioAdministrativo admin_repository;

    /**
     * Método para obtener el listado de administradores existentes
     *
     * @return listado de administradores
     */
    public List<Administrativo> getAll() {
        return admin_repository.getAll();
    }

    /**
     * Método para obtener un administrador específico por el identificador
     *
     * @param id identificador del administrador
     * @return administrador
     */
    public Administrativo getById(int id) {
        Optional<Administrativo> admin = admin_repository.getById(id);
        return admin.orElse(new Administrativo());
    }

    /**
     * Método para crear y/o actualizar un administrador
     *
     * @param admin datos del administrador a crear y/o actualizar
     * @return administrador
     */
    public Administrativo save(Administrativo admin) {
        return admin_repository.save(admin);
    }
    
    /**
     * Método para actualizar una reservación
     *
     * @param admin datos del admin actualizar
     * @return reservación
     */
    public Administrativo update(Administrativo admin){
        if(admin.getIdAdmin()!=null){
            Optional<Administrativo> e= admin_repository.getById(admin.getIdAdmin());
            if(e.isPresent()){
                if(admin.getName()!=null){
                    e.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    e.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    e.get().setPassword(admin.getPassword());
                }
                admin_repository.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
    
     /**
     * Método para eliminar una reservación
     *
     * @param id identificador de la reservación a eliminar
     * @return booleano de confirmación
     */
    public boolean delete(int id) {
        return admin_repository.getById(id).map(admin -> {
            admin_repository.delete(admin);
            return true;
        }).orElse(false);
    }

}
