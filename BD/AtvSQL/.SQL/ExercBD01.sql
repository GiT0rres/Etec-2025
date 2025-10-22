--criando um BD
create database ExercBD01

--abrindo um bd
use ExercBD01

create table pet
(
NumRegistro int,
Nome varchar (80),
Especie varchar (25),
Raca varchar (30),
Cor varchar (40),
Nascimento datetime,
Sexo varchar (9)
);

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (1, 'Kaizer', 'Gato', 'Vira-lata', 'Preto', '08/03/2020', 'Masculino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (2, 'Jujuba', 'Cachorro', 'Pug', 'Preto', '23/08/2019', 'Feminino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (3, 'Nemo', 'Peixe', 'Beta', 'Laranja', '08/06/2023', 'Masculino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (4, 'Carlinhos', 'Coelho', 'Mini Lop', 'Branco', '26/03/2024', 'Masculino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (5, 'Kiwi', 'Gato', 'Angorá', 'Laranja', '18/09/2020', 'Masculino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (6, 'Tulipa', 'Hamster', 'Roborovski', 'Marrom', '21/04/2023', 'Feminino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (7, 'Juka', 'Cachorro', 'Pinscher', 'Marrom e Branco', '15/10/2021', 'Masculino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (8, 'Empada', 'Calopsita', 'Arlequim', 'Amarelo', '10/07/2019', 'Feminino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (9, 'Perna-Longa', 'Coelho', 'Beveren', 'Branco', '11/02/2022', 'Masculino');

insert into pet (NumRegistro, Nome, Especie, Raca, Cor, Nascimento, Sexo)
values (10, 'Cascuda', 'Jabuti', 'Jabuti-tinga', 'Preto', '08/03/2020', 'Feminino');

use master
drop database ExercBD01