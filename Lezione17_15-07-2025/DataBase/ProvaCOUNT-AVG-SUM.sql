-- Funzione COUNT
SELECT Continent, COUNT(Name) AS TotaleCittà
FROM world.country
GROUP BY Continent;

-- Funzione SUM
SELECT Continent, SUM(Population) AS TotalePopolazione
FROM world.country
GROUP BY Continent;

-- Funzione AVG
SELECT Region, AVG(IndepYear) AS MediaAnno
FROM world.country
GROUP BY Region;