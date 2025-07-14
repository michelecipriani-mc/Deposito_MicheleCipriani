SELECT Region, COUNT(Code)
FROM world.country
GROUP BY Region;