/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;


import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;


public class DAOUsuarioImpl extends DAO {
    
 public void agregarUsuario(Usuario usuario) {
    begin();
    getSession().save(usuario);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla usuario
        * @return Este metodo nos regresa todos los usuario
        */
    public ArrayList<Usuario> buscarTodosusuarios() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
        Criteria c=getSession().createCriteria(Usuario.class);
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>)c.list();
        commit();
        close();
         
return usuarios; 
        
      
    }
    /**
     * Este metodo borra un usuario
     * @param u Se le debe pasar un parametro de 
     * tipo usuario para ser borrado
     */
 public void borrarUsuario(Usuario u){
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
  public Usuario buscarPorId(int id_usuario){
      begin();
     Query q = getSession().createQuery("from Usuario where id_usuario = :id_usuario");
        q.setInteger("id_usuario",id_usuario);
        Usuario u = (Usuario)q.uniqueResult();
        commit();
        close();
return u;  
   
  }  }
