SELECT Region, COUNT(Code)
FROM world.country
GROUP BY Region
ORDER BY COUNT(Code) DESC;