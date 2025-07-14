SELECT *
FROM world.country
WHERE Continent = 'Asia' AND (Region = 'Middle East' OR NOT Region = 'Southern and Central Asia');