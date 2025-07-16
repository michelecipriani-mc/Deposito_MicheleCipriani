USE world;

CREATE VIEW citta_italiane AS
SELECT city.CountryCode AS Codice, city.Name AS Città, city.Population AS Popolazione
FROM city
WHERE city.CountryCode = 'ITA' AND city.Population < 100000;

DROP View citta_italiane;

