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
DataAdmissao date,
DataCadastro date ,
Sexo char (1)
);

insert into Departamento (CodDepto, NomeDepto) values
(1, 'Recursos Humanos'),
(2, 'Financeiro'),
(3, 'TI'),
(4, 'Marketing'),
(5, 'Vendas');

insert into Funcionario (CodFunc, NomeFunc, CodDepto, Ramal, Salario, DataAdmissao, DataCadastro, Sexo) values
(101, 'Ana Souza', 1, 1010, 4500.00, '20/05/2019', '10/05/2019', 'F'),
(102, 'Carlos Silva', 1, 1011, 4800.00, '18/08/2020', '05/08/2020', 'M'),
(103, 'Beatriz Oliveira', 2, 2010, 5200.00, '13/03/2025','01/03/2025' , 'F'),
(104, 'Diego Martins', 2, 2011, 5300.00, '21/07/2019', '06/07/2019' ,'M'),
(105, 'Elisa Ramos', 3, 3010, 6000.00, '17/11/2024','03/11/2024' ,'F'),
(106, 'Fernando Costa', 3, 3011, 6200.00, '26/09/2022', '12/09/2022','M'),
(107, 'Gabriela Lima', 4, 4010, 4900.00, '20/02/2021','09/02/2021','F'),
(108, 'Henrique Alves', 4, 4011, 5000.00, '02/12/2010','22/11/2010' ,'M'),
(109, 'Isabela Rocha', 5, 5010, 4700.00, '18/06/2018', '05/06/2018' ,'F'),
(110, 'João Mendes', 5, 5011, 4800.00, '01/09/2021','23/09/2021','M');

select * from Departamento
select * from Funcionario
use master
drop database ExercBD02