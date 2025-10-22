
--Produto (PAPELARIA)
create database ExercBD03
Use ExercBD03
create table Produto(
ID_produto int PRIMARY KEY,
Nome_produto Varchar (100) NOT NULL, 
Preco float NOT NULL,
Quantidade_estoque int NOT NULL,
Cod_barras varchar (50) UNIQUE,
Marca_produto varchar (50) NOT NULL
);
use master
drop database ExercBD03