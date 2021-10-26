/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Categoria;
import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.repositorios.RepositorioOrtesis;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * version 1.0 Claase Servicios para Ortesis
 *
 * @author Jhon Ferney Herrera Grupo G-26
 */
@Service
public class ServiciosOrtesis {
    /**
    * Variable que envia datos a repositorioCrud Ortesis
    */
    @Autowired
    private RepositorioOrtesis metodosCrud;

    /**
     * Método para obtener lista de Ortesis
     *
     * @return listado obtenido
     */
    public List<Ortesis> getAll() {
        return metodosCrud.getAll();
    }

    /**
     * Método para obtener Ortesis por id
     *
     * @param ortesisId
     * @return ortesis obtenida
     */
    public Optional<Ortesis> getOrtesis(int ortesisId) {
        return metodosCrud.getOrtesis(ortesisId);
    }

    /**
     * Método para guardar ortesis
     *
     * @param ortesis
     * @return listado obtenido
     */
    public Ortesis save(Ortesis ortesis) {
        if (ortesis.getId() == null) {
            return metodosCrud.save(ortesis);
        } else {
            Optional<Ortesis> e = metodosCrud.getOrtesis(ortesis.getId());

            if (e.isPresent()) {
                return metodosCrud.save(ortesis);
            } else {
                return ortesis;
            }
        }
    }

    /**
     * Método optional que valida la informcion traida para actualizar
     *
     * @param ortesis
     * @return listado obtenido
     */
    public Ortesis update(Ortesis ortesis) {
        if (ortesis.getId() != null) {
            Optional<Ortesis> e = metodosCrud.getOrtesis(ortesis.getId());
            if (!e.isPresent()) {
                if (ortesis.getName() != null) {
                    e.get().setName(ortesis.getName());
                }
                if (ortesis.getBrand() != null) {
                    e.get().setBrand(ortesis.getBrand());
                }
                if (ortesis.getYear() != null) {
                    e.get().setYear(ortesis.getYear());
                }
                if (ortesis.getDescription() != null) {
                    e.get().setDescription(ortesis.getDescription());
                }
                if (ortesis.getCategory() != null) {
                    e.get().setCategory((Categoria) ortesis.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return ortesis;
            }
        } else {
            return ortesis;
        }
    }

    /**
     * Método para eliminar una Ortesis
     *
     * @param ortesisId
     * @return listado obtenido
     */
    public boolean deleteOrtesis(int ortesisId) {
        Boolean aBoolean = getOrtesis(ortesisId).map(ortesis -> {
            metodosCrud.delete(ortesis);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
