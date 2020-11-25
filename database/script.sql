select * from TB_MATERIAS;

CREATE TABLE TB_MATERIAS 
(
    id            INTEGER       CONSTRAINT id_pk PRIMARY KEY ON CONFLICT ROLLBACK AUTOINCREMENT,
    nome          VARCHAR (150) NOT NULL,
    carga_horaria INTEGER       NOT NULL
);

insert into TB_MATERIAS(nome , carga_horaria) values ('arquitetura e organização de computadores' , 80);
insert into TB_MATERIAS(nome , carga_horaria) values ('banco de dados I' , 40);
insert into TB_MATERIAS(nome , carga_horaria) values ('banco de dados II' , 40);
insert into TB_MATERIAS(nome , carga_horaria) values ('laboratorio de hardware' , 60);
insert into TB_MATERIAS(nome , carga_horaria) values ('sistemas operacionais I' , 40);
insert into TB_MATERIAS(nome , carga_horaria) values ('sistemas operacionais II' , 40);
insert into TB_MATERIAS(nome , carga_horaria) values ('tecnologias para mobilidade' , 80);
insert into TB_MATERIAS(nome , carga_horaria) values ('lógica de programação' , 80);
insert into TB_MATERIAS(nome , carga_horaria) values ('arduino' , 40);
insert into TB_MATERIAS(nome , carga_horaria) values ('teoria de programação orientada a objetos' , 80);