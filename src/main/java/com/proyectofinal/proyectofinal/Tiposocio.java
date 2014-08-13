/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author lauraflamenco
 */
@Entity
@Table(name = "Tipo_socio")
@NamedQueries({
    @NamedQuery(name = "Tiposocio.findAll", query = "SELECT t FROM Tiposocio t")})
public class Tiposocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_socio")
    private Integer idTipoSocio;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
   

    public Tiposocio() {
    }

    public Tiposocio(Integer idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public Tiposocio(Integer idTipoSocio, String descripcion) {
        this.idTipoSocio = idTipoSocio;
        this.descripcion = descripcion;
    
    }

    public Integer getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(Integer idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSocio != null ? idTipoSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposocio)) {
            return false;
        }
        Tiposocio other = (Tiposocio) object;
        if ((this.idTipoSocio == null && other.idTipoSocio != null) || (this.idTipoSocio != null && !this.idTipoSocio.equals(other.idTipoSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyectofinal.proyectofinal.Tiposocio[ idTipoSocio=" + idTipoSocio + " ]";
    }
    
}
