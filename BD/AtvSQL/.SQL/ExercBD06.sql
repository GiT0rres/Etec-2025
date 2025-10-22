-- BD SETOR FINANCEIRO
create database ExercBD06
use ExercBD06

create table SetorFinanceiro
(
ID_setor int PRIMARY KEY,
Nome_setor varchar (50) NOT NULL,
Gerente varchar (100) NOT NULL, 
Tipo varchar (50) NOT NULL,
Status_setor varchar (20),
Regiao_operacao varchar (100) NOT NULL,
CNPJ char NOT NULL,
Funcionarios int NOT NULL,
Estado_civil varchar (20) NOT NULL
);

use master
drop database ExercBD06