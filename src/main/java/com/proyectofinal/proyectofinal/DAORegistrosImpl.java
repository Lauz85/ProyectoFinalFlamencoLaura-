/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;


import static com.proyectofinal.proyectofinal.DAO.close;
import static com.proyectofinal.proyectofinal.DAO.getSession;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;


public class DAORegistrosImpl extends DAO {
   
    
 public void agregarRegistros(Registros registros) {
    begin();
    getSession().save(registros);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla usuario
        * @return Este metodo nos regresa todos los usuario
        */
    public List<Registros> buscarTodosRegistros() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
    Criteria c=getSession().createCriteria(Registros.class);
    List<Registros> registros = (List<Registros>)c.list();
    commit();
    close();
         
return registros; 
        
   
        


    }
    /**
     * Este metodo borra un usuario
     * @param u Se le debe pasar un parametro de 
     * tipo usuario para ser borrado
     */
 public void borrarRegistros (Registros u){
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
  public Registros buscarPorId(int id_registro){
      begin();
     Query q = getSession().createQuery
        ("from registros where id_registro = :id_registro");
        q.setInteger("id_registro",id_registro);
        Registros u = (Registros)q.uniqueResult();
        commit();
        close();
return u;  
   
  }  }
