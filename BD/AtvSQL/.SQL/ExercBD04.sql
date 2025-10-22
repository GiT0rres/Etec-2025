--Funcionario (Escola)
create database ExercBD04 
use ExercBD04
create table Funcionario( Matricula varchar (20) PRIMARY KEY, Nome varchar (100) NOT NULL,
CPF char UNIQUE,
RG varchar (15) UNIQUE, Data_nascimento date NOT NULL,
Cargo Varchar (50) NOT NULL,
Salario float NOT NULL,
Endereco varchar (255) NOT NULL, Sexo char(1),
Estado_civil varchar (20) NOT NULL
);
use master
drop database ExercBD04
