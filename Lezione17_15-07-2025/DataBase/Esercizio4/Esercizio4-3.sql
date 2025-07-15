-- Update dell' anno di pubblicazione per avere lo stesso anno su più record
UPDATE Libri
SET anno_pubblicazione = 2013
WHERE id = 9;
/* Ordinamento risultati (ORDER BY)
Scrivere una query che elenchi tutti i libri pubblicati dopo l'anno 2010 
ordinati in modo decrescente per anno di pubblicazione e, 
in caso di anno uguale, in ordine crescente per prezzo
 */
SELECT *
FROM Libri
WHERE anno_pubblicazione > 2010
ORDER BY anno_pubblicazione DESC, prezzo ASC;