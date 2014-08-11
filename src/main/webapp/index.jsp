<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Final</title>
 
     
           
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        
           <TABLE BORDER=0 WIDTH=450>
               
        <TD WIDTH=150> <center>Nombre</center></TD>
        <TD WIDTH=150> <center>Correo</center></TD> 
        <TD WIDTH=150> <center>id_puesto</center><Id_Puesto</TD> 
            </TABLE>
        
    <input type="text" id="nombre" />
    <input type="text" id="correo" />
    <input type="text" id="id_puesto" />
    <input type="button" value="Guardar usuario" id="guardar">
        
     <h2>Oprime el siguiente boton para buscar todos</h2>
    <input type="button" value="Buscar todos los usuarios" id="buscar-todos">
    <div id="resultado-insertar"></div>
    
        <script>
   $("#buscar-todos").click(function(){         
  $.getJSON("http://localhost:8095/ProyectoFinal/servicios/usuario",
  function(result){
    $.each(result, function(i, campo){
      $("div").append("<li>"+campo.nombre + " "+campo.correo+""+campo.id_puesto);
    });
  });
});

$("#guardar").click(function(){
    var name=$("#nombre").val();
    var correo=$("#correo").val();
    var id_puesto=$("#id_puesto").val();
    $.ajax({
        method:'GET',
        url:"http://localhost:8095/ProyectoFinal/servicios/usuario/"+campo.nombre + ""+campo.correo+""+campo.id_puesto,
        success:function(valor){
            alert(valor)
        },
        failure:function(e){
            alert(e);
        }
    });
});

            
             </script>
        
    </body>
</html>
