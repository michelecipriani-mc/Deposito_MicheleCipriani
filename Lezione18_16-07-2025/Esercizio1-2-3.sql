-- ESERCIZIO 1
SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua, countrylanguage.Percentage AS PercentualeLingua
FROM country INNER JOIN countrylanguage ON country.Code = countrylanguage.CountryCode;

-- ESERCIZIO 2
SELECT country.Name AS Nazione, cl.Language AS Lingua, cl.Percentage AS PercentualeLingua
FROM country INNER JOIN countrylanguage cl 
ON country.Code = cl.CountryCode
WHERE cl.Percentage >= ALL 
(SELECT cl1.Percentage FROM countrylanguage cl1 WHERE cl1.CountryCode = cl.CountryCode)
ORDER BY cl.Percentage DESC;

-- ESERCIZIO 3
SELECT c.Name AS Nazione, cl.Language AS Lingua, cl.Percentage AS PercentualeLingua
FROM country c INNER JOIN countrylanguage cl
ON c.Code = cl.CountryCode
WHERE cl.Percentage = 
(SELECT MAX(cl1.Percentage)
FROM countrylanguage cl1
WHERE cl1.CountryCode = cl.CountryCode)
ORDER BY cl.Percentage DESC;