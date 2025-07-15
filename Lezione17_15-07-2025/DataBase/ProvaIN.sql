-- Prova IN
SELECT *
FROM world.country
WHERE Continent NOT IN('Asia', 'Africa');

SELECT *
FROM world.country
WHERE Continent IN('Europe');