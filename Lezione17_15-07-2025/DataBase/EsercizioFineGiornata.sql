-- Esercizio 1 
SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua, countrylanguage.Percentage AS Percentuale
FROM country LEFT JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
UNION
SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua, countrylanguage.Percentage AS Percentuale
FROM country RIGHT JOIN countrylanguage ON country.Code = countrylanguage.CountryCode;

