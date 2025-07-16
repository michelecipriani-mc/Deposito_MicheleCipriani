CREATE DATABASE dataBase_prova;

CREATE TABLE Ciao (
	id INT PRIMARY KEY,
    nome VARCHAR(100),
    cognome VARCHAR(100),
    CF VARCHAR(100)
);


DROP TABLE Ciao;
DROP DATABASE database_prova;

CREATE TABLE TestTable
SELECT nome, cognome
FROM Ciao;

DROP TABLE testtable;