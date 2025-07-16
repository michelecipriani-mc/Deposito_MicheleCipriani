-- Esercizio 2
SELECT city.Name AS Città, city.CountryCode AS Codice, city.Population AS Popolazione,
CASE
	WHEN IFNULL(city.Population,0) >= 500000  THEN "Grande Città"
    ELSE 'Piccola Città'
END AS Categoria
FROM city
WHERE city.CountryCode = IFNULL(city.CountryCode, 'ITA') AND city.Population >= IFNULL(city.Population, 500000)
ORDER BY 
CASE
	WHEN IFNULL(city.Population,0) < 500000  THEN city.Population
    ELSE NULL
END ASC,
CASE
	WHEN IFNULL(city.Population,0) >= 500000  THEN city.Population
    ELSE NULL
END DESC;
