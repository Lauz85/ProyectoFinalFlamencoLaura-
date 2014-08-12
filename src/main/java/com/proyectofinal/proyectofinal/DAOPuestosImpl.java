/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;


import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;


public class DAOPuestosImpl extends DAO {
    
 public void agregarPuesto(Puestos puesto) {
    begin();
    getSession().save(puesto);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla usuario
        * @return Este metodo nos regresa todos los usuario
        */
    public ArrayList<Puestos> buscarTodospuestos() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Puestos.class);
        ArrayList<Puestos> puesto = (ArrayList<Puestos>)c.list();
        commit();
        close();
         
return puesto; 
        
      
    }
    /**
     * Este metodo borra un usuario
     * @param u Se le debe pasar un parametro de 
     * tipo usuario para ser borrado
     */
 public void borrarPuestos ( Puestos u){
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
  public Puestos buscarPorId(int id_puesto){
      begin();
     Query q = getSession().createQuery("from Puestos where id_puesto = :id_puesto");
        q.setInteger("id_puesto",id_puesto);
        Puestos u = (Puestos)q.uniqueResult();
        commit();
        close();
return u;  
   
  }  }
