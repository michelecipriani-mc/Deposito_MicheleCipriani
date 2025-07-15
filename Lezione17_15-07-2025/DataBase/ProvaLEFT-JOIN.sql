-- Prova LEFT JOIN
SELECT city.Name AS cityName, country.Name AS countryName
FROM city LEFT JOIN country ON city.CountryCode = country.Code;