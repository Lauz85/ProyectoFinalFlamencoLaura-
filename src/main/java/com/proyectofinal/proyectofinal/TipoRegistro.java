/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;

import java.io.Serializable;
import java.util.List;
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
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_Reg")
    private Integer idtipoReg;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idtipoReg")
    private List<Registros> registrosList;

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

    public List<Registros> getRegistrosList() {
        return registrosList;
    }

    public void setRegistrosList(List<Registros> registrosList) {
        this.registrosList = registrosList;
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
        return "com.TipoRegistro[ idtipoReg=" + idtipoReg + " ]";
    }
    
}
