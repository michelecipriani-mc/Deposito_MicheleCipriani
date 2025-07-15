/* Aggregazione e raggruppamento (GROUP BY)
Scrivere una query che, usando il comando GROUP BY, mostri per ogni genere:
il numero totale di libri presenti;
il prezzo medio dei libri appartenenti a quel genere.
La query dovrà restituire il risultato ordinato alfabeticamente per genere. */
SELECT genere, COUNT(genere) AS TOTGenere, FORMAT(AVG(prezzo),2) AS MediaPrezzo
FROM Libri
GROUP BY genere
ORDER BY genere ASC;