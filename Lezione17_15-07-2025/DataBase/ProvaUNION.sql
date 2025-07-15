-- Prova UNION
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
LEFT JOIN Country ON City.CountryCode = Country.Code
UNION
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
RIGHT JOIN Country ON City.CountryCode = Country.Code;