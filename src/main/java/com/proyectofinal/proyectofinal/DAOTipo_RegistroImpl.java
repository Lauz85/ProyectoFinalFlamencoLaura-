/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;


import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;


public class DAOTipo_RegistroImpl extends DAO {
   
    
 public void agregarTipoRegistro(TipoRegistro tipoRegistro) {
    begin();
    getSession().save(tipoRegistro);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla usuario
        * @return Este metodo nos regresa todos los usuario
        */
    public ArrayList<TipoRegistro> buscarTodoTiposRegistros() {
        begin();
      //  Query q = getSession().createQuery("from Usuario");
    Criteria c=getSession().createCriteria(TipoRegistro.class);
    ArrayList<TipoRegistro>
       tipoRegistros = (ArrayList<TipoRegistro>)c.list();
    commit();
    close();
         
return tipoRegistros; 
        
      
    }
    /**
     * Este metodo borra un usuario
     * @param u Se le debe pasar un parametro de 
     * tipo usuario para ser borrado
     */
 public void borrarTipoReg (TipoRegistro u){
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
  public TipoRegistro buscarPorId(int id_tipo_registro){
      begin();
     Query q = getSession().createQuery
        ("from Tipo_Registro where id_tipo_Reg = :id_tipo_Reg");
        q.setInteger("id_tipo_Reg",id_tipo_registro);
        TipoRegistro u = (TipoRegistro)q.uniqueResult();
        commit();
        close();
return u;  
   
  }  }
