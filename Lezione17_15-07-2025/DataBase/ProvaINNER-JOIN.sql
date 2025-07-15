-- Prova INNER JOIN
SELECT ID, Code, city.Name AS CityName, country.Name AS CountryName, city.Population AS CityPopulation, country.Population AS CountryPopulation, Region
FROM world.city INNER JOIN world.country
ON world.city.CountryCode=world.country.Code;