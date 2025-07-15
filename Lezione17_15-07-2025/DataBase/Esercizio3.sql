SELECT Continent, COUNT(Continent) AS Continent, SUM(Population) AS Population
FROM world.country
GROUP BY Continent
ORDER BY Population DESC;