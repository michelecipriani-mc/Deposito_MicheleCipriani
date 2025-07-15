-- Prova BETWEEN
SELECT *
FROM world.country
WHERE IndepYear BETWEEN 1900 AND 1970 AND Continent NOT IN('Africa');

SELECT *
FROM world.country
WHERE IndepYear NOT BETWEEN 1900 AND 1970 AND Continent NOT IN('Africa');