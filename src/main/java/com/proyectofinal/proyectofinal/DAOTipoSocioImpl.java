/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;


import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;


public class DAOTipoSocioImpl extends DAO {
    
 public void agregarTipoSocio(Tiposocio tiposocio) {
    begin();
    getSession().save(tiposocio);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla usuario
        * @return Este metodo nos regresa todos los usuario
        */
    public ArrayList<Tiposocio> buscarTodosTiposSocios() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Tiposocio.class);
        ArrayList<Tiposocio> Tiposocios = (ArrayList<Tiposocio>)c.list();
        commit();
        close();
         
return Tiposocios; 
        
      
    }
    /**
     * Este metodo borra un usuario
     * @param u Se le debe pasar un parametro de 
     * tipo usuario para ser borrado
     */
 public void borrarTiposocio ( Tiposocio u){
            begin();
            getSession().delete(u);
            commit();
            close();
 }   
        /**
         * Este metodo busca un usuario por medio de su Id
         * @param id Este parametro es el Id del 
         * usuario que se quiere buscar
         * @return El tipo de retorno es el usuario buscado
         */
  public Tiposocio buscarPorId(int id_socio){
      begin();
     Query q = getSession().createQuery("from Tiposocio where id_socio = :id_socio");
        q.setInteger("id_socio",id_socio);
        Tiposocio u = (Tiposocio)q.uniqueResult();
        commit();
        close();
return u;  
   
  }  }
