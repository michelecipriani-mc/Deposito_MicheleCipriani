-- Totale vendite per categoria
SELECT categoria, COUNT(prodotto) AS TotaleVendite
FROM Vendite
GROUP BY categoria;

-- Prezzo medio per categoria
SELECT categoria, FORMAT(AVG(prezzo_unitario),2) AS PrezzoMedio
FROM Vendite
GROUP BY categoria;

-- Prezzo medio per categoria
SELECT prodotto, SUM(quantita) AS VenditePerProdotto
FROM Vendite
GROUP BY prodotto;

-- Prezzo Massimo
SELECT MAX(prezzo_unitario) AS PrezzoMassimo
FROM Vendite;

-- Prezzo Minimo
SELECT MIN(prezzo_unitario) AS PrezzoMinimo
FROM Vendite;

-- Prezzo Minimo
SELECT COUNT(id) AS TotaleVendite
FROM Vendite;

-- 5 prodotti più Costosi
SELECT prodotto, MAX(prezzo_unitario) AS Costo
FROM Vendite
GROUP BY prodotto
ORDER BY Costo DESC
LIMIT 5;

-- 3 Prodotti meno venduti
SELECT prodotto, SUM(quantita) AS Quantità
FROM Vendite
GROUP BY prodotto
ORDER BY Quantità ASC
LIMIT 3;