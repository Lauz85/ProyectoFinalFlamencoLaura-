/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;


import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;


public class DAOSocioImpl extends DAO {
    
 public void agregarSocio(Socio socio) {
    begin();
    getSession().save(socio);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla usuario
        * @return Este metodo nos regresa todos los usuario
        */
    public ArrayList<Socio> buscarTodosSocios() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Socio.class);
        ArrayList<Socio> socios = (ArrayList<Socio>)c.list();
        commit();
        close();
         
return socios; 
        
      
    }
    /**
     * Este metodo borra un usuario
     * @param u Se le debe pasar un parametro de 
     * tipo usuario para ser borrado
     */
 public void borrarSocio ( Socio u){
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
  public Socio buscarPorId(int id_socio){
      begin();
     Query q = getSession().createQuery("from Socio where id_socio = :id_socio");
        q.setInteger("id_socio",id_socio);
        Socio u = (Socio)q.uniqueResult();
        commit();
        close();
return u;  
   
  }  }
