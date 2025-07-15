-- Esercizio 1 INNER JOIN
SELECT Cli.nome AS NomeCliente, Ordini.data_ordine AS DataOrdine, Ordini.importo AS Importo
FROM Cli INNER JOIN Ordini ON Cli.id = Ordini.id_cliente;

-- Esercizio 2 LEFT JOIN
SELECT Cli.nome AS NomeCliente, Ordini.data_ordine AS DataOrdine, Ordini.importo AS Importo
FROM Cli LEFT JOIN Ordini ON Cli.id = Ordini.id_cliente;

-- Esercizio 3 RIGHT JOIN
SELECT Ordini.data_ordine AS DataOrdine, Ordini.importo AS Importo, Cli.nome AS NomeCliente
FROM Cli RIGHT JOIN Ordini ON Cli.id = Ordini.id_cliente;

-- -- Esercizio 4 INNER JOIN EXTRA
SELECT Cli.nome AS NomeCliente, COUNT(Ordini.data_ordine) AS NumeroOrdini, SUM(Ordini.importo) AS ImportoSpeso
FROM Cli INNER JOIN Ordini ON Cli.id = Ordini.id_cliente
GROUP BY NomeCliente ORDER BY ImportoSpeso DESC;

-- Esercizio 5 LEFT JOIN EXTRA
SELECT Cli.nome AS NomeCliente, Cli.città AS Città
FROM Cli LEFT JOIN Ordini ON Cli.id = Ordini.id_cliente
WHERE Ordini.data_ordine IS NULL AND Ordini.importo IS NULL;

-- Esercizio 6 RIGHT JOIN EXTRA
SELECT Ordini.id AS ID_Ordine, Ordini.data_ordine AS DataOrdine, Ordini.importo AS Importo
FROM Cli RIGHT JOIN Ordini ON Cli.id = Ordini.id_cliente
WHERE Ordini.id_cliente IS NULL;