/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.proyecto.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "LOCALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"),
    @NamedQuery(name = "Localidad.findByNumerolocalidad", query = "SELECT l FROM Localidad l WHERE l.numerolocalidad = :numerolocalidad"),
    @NamedQuery(name = "Localidad.findByNombre", query = "SELECT l FROM Localidad l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Localidad.findByPoblacion", query = "SELECT l FROM Localidad l WHERE l.poblacion = :poblacion")})
public class Localidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROLOCALIDAD")
    private Integer numerolocalidad;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "POBLACION")
    private Integer poblacion;
    @OneToMany(mappedBy = "numerolocalidad")
    private Collection<Proyecto> proyectoCollection;

    public Localidad() {
    }

    public Localidad(Integer numerolocalidad, String nombre, Integer poblacion) {
        this.numerolocalidad = numerolocalidad;
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    public Localidad(Integer numerolocalidad) {
        this.numerolocalidad = numerolocalidad;
    }

    public Integer getNumerolocalidad() {
        return numerolocalidad;
    }

    public void setNumerolocalidad(Integer numerolocalidad) {
        this.numerolocalidad = numerolocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerolocalidad != null ? numerolocalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.numerolocalidad == null && other.numerolocalidad != null) || (this.numerolocalidad != null && !this.numerolocalidad.equals(other.numerolocalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ numerolocalidad=" + numerolocalidad + ", nombre=" + nombre + " ]";
    }
    
}
