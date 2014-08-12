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
public class ControlladorPuestos{
 
   
    @RequestMapping(value="/puestos/{puestos}", 
    //Para el insert siempre debe ser con POST         
    method=RequestMethod.GET, 
    
    //Metodo de presentacion
    headers={"Accept=text/html"})
    
    //Visto para todos por ello Public 
    
    public @ResponseBody
            
    //        
    String metodo2( @PathVariable String Puesto){
        
    //IMPLEMENTACION 
        DAOPuestosImpl u=new DAOPuestosImpl() ;
        u.agregarPuesto(new Puestos(1,Puesto));
        return "El Puesto se agrego con exito";
  
    }
    
   //PRESENTACION DE TODOS 
    @RequestMapping(value="/Puestos", method=RequestMethod.GET, 
            headers={"Accept=application/json"})
    public @ResponseBody String metodo1()throws Exception{
     
   DAOPuestosImpl g=new DAOPuestosImpl();
  
  Map<String,ArrayList<Puestos>> singletonMap =Collections.singletonMap("Puestos", g.buscarTodospuestos());
  ObjectMapper mapper=new ObjectMapper();
  
  return mapper.writeValueAsString(g.buscarTodospuestos());
    }
     
   
    
}
