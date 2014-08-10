create table registros(id_registro integer primary key
                  auto_increment,
                  id_usuario integer,
                  id_tipo_Reg integer,
                  id_tipo_socio integer, 
                  id_socio integer,
                  direccion varchar(200),
                  usuario varchar(50),
                  clave varchar(50),
                  observaciones varchar(100),
                  constraint foreign key (id_tipo_Reg) references  
                  Tipo_Registro(id_tipo_Reg),
                  constraint foreign key (id_tipo_socio) references  
                  Tipo_socio(id_tipo_socio),
                  constraint foreign key (id_socio) references  
                  socio(id_socio));

               