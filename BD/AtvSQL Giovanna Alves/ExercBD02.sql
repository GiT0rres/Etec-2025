--ExercBD02
create database ExercBD02
use ExercBD02

create table Departamento (
CodDepto int, --criando campo CodDepto
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

insert into Departamento (CodDepto, NomeDepto) values
(1, 'Recursos Humanos'),
(2, 'Financeiro'),
(3, 'TI'),
(4, 'Marketing'),
(5, 'Vendas');

insert into Funcionario (CodFunc, NomeFunc, CodDepto, Ramal, Salario, DataAdmissao, Sexo) values
(101, 'Ana Souza', 1, 1010, 4500.00, '2020-05-10', 'F'),
(102, 'Carlos Silva', 1, 1011, 4800.00, '2018-08-20', 'M'),
(103, 'Beatriz Oliveira', 2, 2010, 5200.00, '2019-03-15', 'F'),
(104, 'Diego Martins', 2, 2011, 5300.00, '2021-07-01', 'M'),
(105, 'Elisa Ramos', 3, 3010, 6000.00, '2017-11-30', 'F'),
(106, 'Fernando Costa', 3, 3011, 6200.00, '2016-09-12', 'M'),
(107, 'Gabriela Lima', 4, 4010, 4900.00, '2022-02-05', 'F'),
(108, 'Henrique Alves', 4, 4011, 5000.00, '2020-12-10', 'M'),
(109, 'Isabela Rocha', 5, 5010, 4700.00, '2018-06-25', 'F'),
(110, 'João Mendes', 5, 5011, 4800.00, '2019-09-30', 'M');

use master
drop database ExercBD02