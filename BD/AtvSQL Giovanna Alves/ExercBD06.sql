-- BD SETOR FINANCEIRO
create database ExercBD
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


INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(1, 'Contabilidade', 'Marcos Silva', 'Administrativo', 'Ativo', 'Sudeste', '12345678000199', 25, 'Casado');
INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(2, 'Tesouraria', 'Ana Paula Souza', 'Financeiro', 'Ativo', 'Sul', '23456789000188', 18, 'Solteira');

INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(3, 'Auditoria Interna', 'Carlos Henrique', 'Controle', 'Ativo', 'Centro-Oeste', '34567890000177', 12, 'Divorciado');

INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(4, 'Planejamento Financeiro', 'Luciana Mendes', 'Estratégico', 'Ativo', 'Nordeste', '45678900000166', 20, 'Casada');

INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(5, 'Controle de Custos', 'Fernando Rocha', 'Financeiro', 'Ativo', 'Norte', '56789000000155', 15, 'Solteiro');

INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(6, 'Relações com Investidores', 'Patrícia Gomes', 'Comunicação', 'Inativo', 'Sudeste', '67890000000144', 10, 'Viúva');

INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(7, 'Contas a Pagar', 'João Alfredo', 'Operacional', 'Ativo', 'Sul', '78900000000133', 22, 'Casado');

INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(8, 'Contas a Receber', 'Márcia Lima', 'Operacional', 'Ativo', 'Nordeste', '89000000000122', 19, 'Solteira');

INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(9, 'Análise de Crédito', 'Roberto Tavares', 'Financeiro', 'Ativo', 'Centro-Oeste', '90000000000111', 14, 'Casado');

INSERT INTO SetorFinanceiro 
(ID_setor, Nome_setor, Gerente, Tipo, Status_setor, Regiao_operacao, CNPJ, Funcionarios, Estado_civil)
VALUES 
(10, 'Orçamento e Previsão', 'Renata Carvalho', 'Planejamento', 'Ativo', 'Norte', '01100000000100', 16, 'Solteira');

select * from SetorFinanceiro; 

use master
drop database ExercBD