/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;

import java.io.Serializable;
import java.util.Collection;
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
@Table(name = "Tipo_Registro")
@NamedQueries({
    @NamedQuery(name = "TipoRegistro.findAll", query = "SELECT t FROM TipoRegistro t")})
public class TipoRegistro implements Serializable {

    public TipoRegistro(Integer idtipoReg, String descripcion, Collection<Registros> registrosCollection) {
        this.idtipoReg = idtipoReg;
        this.descripcion = descripcion;
        this.registrosCollection = registrosCollection;
    }
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_Reg")
    private Integer idtipoReg;

    public TipoRegistro(Integer idtipoReg, String descripcion) {
        this.idtipoReg = idtipoReg;
        this.descripcion = descripcion;
    }
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idtipoReg")
    private Collection<Registros> registrosCollection;

    public TipoRegistro() {
    }

    public TipoRegistro(Integer idtipoReg) {
        this.idtipoReg = idtipoReg;
    }

    public Integer getIdtipoReg() {
        return idtipoReg;
    }

    public void setIdtipoReg(Integer idtipoReg) {
        this.idtipoReg = idtipoReg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Registros> getRegistrosCollection() {
        return registrosCollection;
    }

    public void setRegistrosCollection(Collection<Registros> registrosCollection) {
        this.registrosCollection = registrosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoReg != null ? idtipoReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRegistro)) {
            return false;
        }
        TipoRegistro other = (TipoRegistro) object;
        if ((this.idtipoReg == null && other.idtipoReg != null) || (this.idtipoReg != null && !this.idtipoReg.equals(other.idtipoReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.proyectofinal.proyectofinal.TipoRegistro[ idtipoReg=" + idtipoReg + " ]";
    }
    
}
