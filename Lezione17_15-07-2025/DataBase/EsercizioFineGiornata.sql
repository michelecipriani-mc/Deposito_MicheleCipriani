-- Esercizio 1 
SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua, countrylanguage.Percentage AS Percentuale
FROM country LEFT JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
UNION
SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua, countrylanguage.Percentage AS Percentuale
FROM country RIGHT JOIN countrylanguage ON country.Code = countrylanguage.CountryCode;

-- Esercizio 2
SELECT country.Name AS CountryName, COUNT(city.Name) AS NumeroCittà
FROM country INNER JOIN city ON country.Code = city.CountryCode
GROUP BY CountryName ORDER BY NumeroCittà DESC;

-- Esercizio 3
SELECT country.Name AS CountryName, country.GovernmentForm, country.LifeExpectancy AS AspettativaDiVita, countrylanguage.Language AS Lingua 
FROM country INNER JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE country.GovernmentForm ='Republic' AND country.LifeExpectancy > 70 AND countrylanguage.IsOfficial = 'T';