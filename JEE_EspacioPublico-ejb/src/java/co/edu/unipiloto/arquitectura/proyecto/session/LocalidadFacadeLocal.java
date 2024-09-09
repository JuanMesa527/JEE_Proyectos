/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.proyecto.session;

import co.edu.unipiloto.arquitectura.proyecto.entity.Localidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface LocalidadFacadeLocal {

    void create(Localidad localidad);

    void edit(Localidad localidad);

    void remove(Localidad localidad);

    Localidad find(Object id);

    List<Localidad> findAll();

    List<Localidad> findRange(int[] range);

    int count();
    
}
