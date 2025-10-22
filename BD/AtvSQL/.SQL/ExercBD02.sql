--ExercBD02
create database ExercBD02
use ExercBD02

create table Departamento (
CodFunc int, --criando campo CodFunc
NomeDepto varchar (50), --criando campo NomeDepto
);

create table Funcionario --criando tabela funcionário
(
CodFunc int, 
NomeFunc varchar (50),
CodDepto int,
Ramal int NULL,
Salario float,
DataAdmissao datetime,
DataCadastro datetime,
Sexo char (1)
);
use master
drop database ExercBD02