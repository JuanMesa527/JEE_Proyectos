/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.proyecto.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByProyectoid", query = "SELECT p FROM Proyecto p WHERE p.proyectoid = :proyectoid"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByDescripcion", query = "SELECT p FROM Proyecto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Proyecto.findByPresupuesto", query = "SELECT p FROM Proyecto p WHERE p.presupuesto = :presupuesto")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROYECTOID")
    private Integer proyectoid;
    @Size(max = 250)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRESUPUESTO")
    private Double presupuesto;
    @JoinColumn(name = "NUMEROLOCALIDAD", referencedColumnName = "NUMEROLOCALIDAD")
    @ManyToOne
    private Localidad numerolocalidad;

    public Proyecto() {
    }

    public Proyecto(Integer proyectoid, String nombre, String descripcion, Double presupuesto, Localidad numerolocalidad) {
        this.proyectoid = proyectoid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.presupuesto = presupuesto;
        this.numerolocalidad = numerolocalidad;
    }

    public Proyecto(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Localidad getNumerolocalidad() {
        return numerolocalidad;
    }

    public void setNumerolocalidad(Localidad numerolocalidad) {
        this.numerolocalidad = numerolocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoid != null ? proyectoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.proyectoid == null && other.proyectoid != null) || (this.proyectoid != null && !this.proyectoid.equals(other.proyectoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.proyecto.entity.Proyecto[ proyectoid=" + proyectoid + " ]";
    }
    
}
