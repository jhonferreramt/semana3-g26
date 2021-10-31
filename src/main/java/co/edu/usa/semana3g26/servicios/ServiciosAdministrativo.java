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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase Service ServiciosAdministrativo
 *
 * @version 1.1
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
     * Método para validar los datos de un administrador
     *
     * @param admin datos del administrador a validar
     * @return indicador si los datos son válidos o no
     */
    protected boolean validateData(Administrativo admin) {

        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z"
                + "0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        if (admin.getEmail().length() <= 45 && admin.getEmail() != null) {
            Matcher mather = pattern.matcher(admin.getEmail());

            if (!mather.find()) {
                return false;
            }
        } else {
            return false;
        }

        if (admin.getName().length() > 250 && admin.getName() != null) {
            return false;
        }

        if (admin.getPassword().length() > 45 && admin.getPassword() != null) {
            return false;
        }

        return true;
    }

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
     * Método para crear un administrador
     *
     * @param admin datos del administrador a crear
     * @return administrador
     */
    public Administrativo save(Administrativo admin) {
        if (validateData(admin)) {
            if (admin.getIdAdmin() == null) {
                return admin_repository.save(admin);
            } else {
                Optional<Administrativo> admin_aux = admin_repository.getById(
                        admin.getIdAdmin());
                if (admin_aux.isPresent()) {
                    return admin;
                } else {
                    return admin_repository.save(admin);
                }
            }
        } else {
            return admin;
        }
    }

    /**
     * Método para eliminar un administrador
     *
     * @param id identificador del administrador a eliminar
     * @return booleano de confirmación
     */
    public boolean delete(int id) {
        boolean del = admin_repository.getById(id).map(admin -> {
            admin_repository.delete(admin);
            return true;
        }).orElse(false);
        return del;
    }

    /**
     * Método para actualizar un administrador
     *
     * @param admin datos del administrador a actualizar
     * @return administrador
     */
    public Administrativo update(Administrativo admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Administrativo> admin_consultado = admin_repository.
                    getById(admin.getIdAdmin());
            if (admin_consultado.isPresent() && validateData(admin)) {
                if (admin.getName() != null) {
                    admin_consultado.get().setName(admin.getName());
                }

                if (admin.getEmail() != null) {
                    admin_consultado.get().setEmail(admin.getEmail());
                }

                if (admin.getPassword() != null) {
                    admin_consultado.get().setPassword(admin.getPassword());
                }

                return admin_repository.save(admin_consultado.get());
            }
        }
        return admin;
    }
}
