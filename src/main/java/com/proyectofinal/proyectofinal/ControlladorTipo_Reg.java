/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author lauraflamenco
 */
@Controller
@RequestMapping("/")
public class ControlladorTipo_Reg{
   
    @RequestMapping(value="/TipoRegistro/{descripcion}", 
    //Para el insert siempre debe ser con POST         
    method=RequestMethod.GET, 
    
    //Metodo de presentacion
    headers={"Accept=text/html"})
    
    //Visto para todos por ello Public 
    
    public @ResponseBody
            
    //        
    String metodo2( @PathVariable String descripcion){
        
    //IMPLEMENTACION 
        DAOTipo_RegistroImpl u=new DAOTipo_RegistroImpl() ;
        u.agregarTipoRegistro( new TipoRegistro(1,descripcion));
        return "El tipo se agrego con exito";
  
    }
    
   //PRESENTACION DE TODOS 
    @RequestMapping(value="/Tipo_Reg", method=RequestMethod.GET, 
            headers={"Accept=application/json"})
    public @ResponseBody String metodo1()throws Exception{
     
  DAOTipo_RegistroImpl g=new DAOTipo_RegistroImpl();
  
  Map<String,ArrayList<TipoRegistro>> singletonMap =Collections.singletonMap("TipoRegistro", g.buscarTodoTiposRegistros());
  ObjectMapper mapper=new ObjectMapper();
  
  return mapper.writeValueAsString(g.buscarTodoTiposRegistros());
    }
     
   
    
}
