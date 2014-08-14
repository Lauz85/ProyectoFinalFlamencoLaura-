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
public class ControlladorRegistros {
   
    @RequestMapping(value="/Registros/{id_usuario}/{id_tipo_reg}/{direccion}/{user}/{clave}/{observaciones}/{Socio}/{Tipo_socio/{Tipo_Registro}", 

    //Para el insert siempre debe ser con POST         
    method=RequestMethod.GET, 
    
    //Metodo de presentacion
    headers={"Accept=text/html"})
    
    //Visto para todos por ello Public 
    
    public @ResponseBody
            
    //        
    String metodo2(@PathVariable int id_usuario,
                   @PathVariable int id_tipo_reg,
                   @PathVariable String direccion,
                   @PathVariable String user,
                   @PathVariable String clave,
                   @PathVariable String observaciones,
                   @PathVariable Socio Socio,
                   @PathVariable Tiposocio Tipo_socio,
                   @PathVariable TipoRegistro Tipo_registro
    ){
        
    //IMPLEMENTACION 
       DAORegistrosImpl u=new DAORegistrosImpl();
u.agregarRegistros(new Registros (id_usuario,id_tipo_reg,direccion,user,clave,observaciones,Socio,Tipo_socio,Tipo_registro));
        return "El registro se agrego con exito";
  
    }
    
   //PRESENTACION DE TODOS 
    @RequestMapping(value="/Registros", method=RequestMethod.GET, 
            headers={"Accept=application/json"})
    public @ResponseBody String metodo1()throws Exception{
     
  DAORegistrosImpl g=new DAORegistrosImpl();
  Map<String,List<Registros>> singletonMap =Collections.singletonMap("Registros", g.buscarTodosRegistros());
  ObjectMapper mapper=new ObjectMapper();
  
  return mapper.writeValueAsString(g.buscarTodosRegistros());
    }


   
    
}