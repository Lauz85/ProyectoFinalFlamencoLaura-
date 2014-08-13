/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectofinal.proyectofinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class ControlladorUsuario {
   
    @RequestMapping(value="/usuario/{nombre}/{correo}/{id_puesto}", 
    //Para el insert siempre debe ser con POST         
    method=RequestMethod.GET, 
    
    //Metodo de presentacion
    headers={"Accept=text/html"})
    
    //Visto para todos por ello Public 
    
    public @ResponseBody
            
    //        
    String metodo2(@PathVariable String nombre,
                   @PathVariable String correo,
                   @PathVariable int id_puesto){
        
    //IMPLEMENTACION 
        DAOUsuarioImpl u=new DAOUsuarioImpl();
        u.agregarUsuario ( new Usuario (1,nombre,correo, new Puestos(id_puesto)));
        return "El usuario se agrego con exito";
  
    }
    
   //PRESENTACION DE TODOS 
    @RequestMapping(value="/usuario", method=RequestMethod.GET, 
            headers={"Accept=application/json"})
    public @ResponseBody String metodo1()throws Exception{
     
  DAOUsuarioImpl g=new DAOUsuarioImpl();
  Map<String,List<Usuario>> singletonMap =Collections.singletonMap("usuario", g.buscarTodosusuarios());
  ObjectMapper mapper=new ObjectMapper();
  
  return mapper.writeValueAsString(g.buscarTodosusuarios());
    }
     
   
    
}