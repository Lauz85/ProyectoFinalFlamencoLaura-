/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;

import java.util.ArrayList;
import java.util.Collection;
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
public class ControlladorTiposocio{
     private Collection<Registros> Registros;
    
   
    @RequestMapping(value="/Tiposocio/{nombre}", 
    //Para el insert siempre debe ser con POST         
    method=RequestMethod.GET, 
    
    //Metodo de presentacion
    headers={"Accept=text/html"})
    
    //Visto para todos por ello Public 
    
    public @ResponseBody
            
    //        
    String metodo2( @PathVariable String nombre){
        
    //IMPLEMENTACION 
        DAOTipoSocioImpl u=new DAOTipoSocioImpl() ;
        u.agregarTipoSocio(new Tiposocio(1,nombre,Registros));
       
        return "El Tipo de socio se agrego con exito";
  
    }
    
   //PRESENTACION DE TODOS 
    @RequestMapping(value="/TipoSocio", method=RequestMethod.GET, 
            headers={"Accept=application/json"})
    public @ResponseBody String metodo1()throws Exception{
     
   DAOTipoSocioImpl g=new DAOTipoSocioImpl ();
  
  Map<String,ArrayList<Tiposocio>> singletonMap =Collections.singletonMap("Tiposocio", g.buscarTodosTiposSocios());
  ObjectMapper mapper=new ObjectMapper();
  
  return mapper.writeValueAsString(g.buscarTodosTiposSocios());
    }
     
   
    
}
