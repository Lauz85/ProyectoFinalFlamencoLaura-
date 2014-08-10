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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author lauraflamenco
 */
@Entity
@Table(name = "registros")
@NamedQueries({
    @NamedQuery(name = "Registros.findAll", query = "SELECT r FROM Registros r")})
public class Registros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_registro")
    private Integer idRegistro;
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 50)
    @Column(name = "clave")
    private String clave;
    @Size(max = 100)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_socio", referencedColumnName = "id_socio")
    @ManyToOne
    private Socio idSocio;
    @JoinColumn(name = "id_tipo_socio", referencedColumnName = "id_tipo_socio")
    @ManyToOne
    private Tiposocio idTipoSocio;
    @JoinColumn(name = "id_tipo_Reg", referencedColumnName = "id_tipo_Reg")
    @ManyToOne
    private TipoRegistro idtipoReg;

    public Registros() {
    }

    public Registros(Integer idRegistro, Integer idUsuario, String direccion, String usuario, String clave, String observaciones, Socio idSocio, Tiposocio idTipoSocio, TipoRegistro idtipoReg) {
        this.idRegistro = idRegistro;
        this.idUsuario = idUsuario;
        this.direccion = direccion;
        this.usuario = usuario;
        this.clave = clave;
        this.observaciones = observaciones;
        this.idSocio = idSocio;
        this.idTipoSocio = idTipoSocio;
        this.idtipoReg = idtipoReg;
    }

    public Registros(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Socio getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socio idSocio) {
        this.idSocio = idSocio;
    }

    public Tiposocio getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(Tiposocio idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public TipoRegistro getIdtipoReg() {
        return idtipoReg;
    }

    public void setIdtipoReg(TipoRegistro idtipoReg) {
        this.idtipoReg = idtipoReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registros)) {
            return false;
        }
        Registros other = (Registros) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Registros[ idRegistro=" + idRegistro + " ]";
    }
    
}
