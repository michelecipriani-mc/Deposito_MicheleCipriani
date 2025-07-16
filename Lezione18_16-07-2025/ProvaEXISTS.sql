-- Prova Exists
SELECT country.Name
FROM country
WHERE exists
(SELECT countrylanguage.Language 
FROM countrylanguage 
WHERE countrylanguage.CountryCode = country.Code AND countrylanguage.Language = 'Italian');