-- Clienti con email su dominio Gmail
SELECT *
FROM Clienti
WHERE email LIKE '%gmail%';

-- Seleziona tutti i clienti la cui email termina con @gmail.com
SELECT *
FROM Clienti
WHERE email LIKE '%_gmail.com';

-- Clienti con nome che inizia con la lettera 'A'
SELECT *
FROM Clienti
WHERE nome LIKE 'A%';

-- Clienti con nome che inizia con la lettera a
SELECT *
FROM Clienti
WHERE nome LIKE 'a%' OR nome LIKE 'A%';

-- Clienti con cognome che contiene esattamente 5 lettere
SELECT *
FROM Clienti
WHERE cognome LIKE '_____';

-- Mostra tutti i clienti il cui cognome è composto da esattamente 5 caratteri
SELECT *
FROM Clienti
WHERE LENGTH(cognome) = 5;

-- Clienti con età compresa tra 30 e 40 anni(inclusi)
SELECT eta, COUNT(id) NumeroClienti
FROM Clienti
WHERE eta BETWEEN 30 AND 40
GROUP BY eta
ORDER BY eta ASC;

-- Elenca i clienti che hanno un'età compresa tra 30 e 40 anni, inclusi gli estremi.
SELECT *
FROM Clienti
WHERE eta BETWEEN 30 AND 40;

-- Clienti che vivono in città il cui nome contiene 'roma' (maiuscole/minuscole ignorate)
SELECT citta, COUNT(id) NumeroClienti 
FROM Clienti
WHERE citta LIKE "%roma%"
GROUP BY citta;

-- Mostra tutti i clienti che abitano in una città il cui nome contiene la stringa roma, indipendentemente da maiuscole o minuscole.
SELECT *
FROM Clienti
WHERE citta LIKE "%roma%";