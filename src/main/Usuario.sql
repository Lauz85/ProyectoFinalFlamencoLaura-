create table usuario(id_usuario integer primary key
                  auto_increment,
                  nombre varchar(300),
                  correo varchar(50),
                  id_puesto integer,
                  constraint foreign key(id_puesto)
                  references puestos(id_puesto));

