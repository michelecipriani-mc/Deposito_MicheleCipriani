-- Prova ALL
SELECT Name
FROM country
WHERE Population > ALL(SELECT Population FROM city WHERE CountryCode = 'ITA');