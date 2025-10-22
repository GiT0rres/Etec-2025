-- bd Fornecedor
create database ExercBD05
use ExercBD05

create table Fornecedor
(
ID_fornecedor int PRIMARY KEY,
Nome_empresa varchar (100) NOT NULL,
CNPJ char NOT NULL,
Telefone varchar (20) NOT NULL,
Email varchar (100) NOT NULL,
Endereco varchar (255) NOT NULL
);

use master
drop database ExercBD05