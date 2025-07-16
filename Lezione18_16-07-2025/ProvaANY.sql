-- Prova ANY
SELECT Name
FROM city
WHERE CountryCode = ANY
(SELECT CountryCode FROM countrylanguage WHERE Language= 'Papiamento');