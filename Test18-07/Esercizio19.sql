-- ESERCIZIO 19.1
SELECT title, release_year
FROM film
WHERE release_year > 2005
ORDER BY title ASC;

-- ESERCIZIO 19.2
SELECT r.rental_id, r.rental_date, r.return_date, f.title
FROM rental r INNER JOIN customer c ON r.customer_id = c.customer_id
INNER JOIN inventory i ON r.inventory_id = i.inventory_id
INNER JOIN film f ON i.film_id = f.film_id
WHERE c.first_name = 'MARY' AND c.last_name = 'SMITH'
ORDER BY r.rental_date;

-- ESERCIZIO 19.3
SELECT f.title, COUNT(r.rental_id) AS numero_noleggi
FROM film f
INNER JOIN inventory i ON f.film_id = i.film_id
INNER JOIN rental r ON i.inventory_id = r.inventory_id
GROUP BY f.title
ORDER BY numero_noleggi DESC;

-- ESERCIZIO 19.4
SELECT f.title
FROM film f
LEFT JOIN inventory i ON f.film_id = i.film_id
LEFT JOIN rental r ON i.inventory_id = r.inventory_id
WHERE r.rental_id IS NULL
GROUP BY f.title;

-- ESERCIZIO 19.5
SELECT c.name AS categoria, COUNT(r.rental_id) AS totale_noleggi
FROM rental r
INNER JOIN inventory i ON r.inventory_id = i.inventory_id
INNER JOIN film f ON i.film_id = f.film_id
INNER JOIN film_category fc ON f.film_id = fc.film_id
INNER JOIN category c ON fc.category_id = c.category_id
GROUP BY c.name
ORDER BY totale_noleggi DESC
LIMIT 1;