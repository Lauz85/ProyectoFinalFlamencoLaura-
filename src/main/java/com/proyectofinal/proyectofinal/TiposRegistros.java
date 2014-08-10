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
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author lauraflamenco
 */
@Entity
@Table(name = "Tipos_Registros")
@NamedQueries({
    @NamedQuery(name = "TiposRegistros.findAll", query = "SELECT t FROM TiposRegistros t")})
public class TiposRegistros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_reg")
    private Integer idTipoReg;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;

    public TiposRegistros() {
    }

    public TiposRegistros(Integer idTipoReg) {
        this.idTipoReg = idTipoReg;
    }

    public Integer getIdTipoReg() {
        return idTipoReg;
    }

    public void setIdTipoReg(Integer idTipoReg) {
        this.idTipoReg = idTipoReg;
    }

    public TiposRegistros(Integer idTipoReg, String descripcion) {
        this.idTipoReg = idTipoReg;
        this.descripcion = descripcion;
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
        hash += (idTipoReg != null ? idTipoReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposRegistros)) {
            return false;
        }
        TiposRegistros other = (TiposRegistros) object;
        if ((this.idTipoReg == null && other.idTipoReg != null) || (this.idTipoReg != null && !this.idTipoReg.equals(other.idTipoReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.TiposRegistros[ idTipoReg=" + idTipoReg + " ]";
    }
    
}
