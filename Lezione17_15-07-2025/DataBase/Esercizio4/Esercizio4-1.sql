-- Creazione della tabella con i parametri
CREATE TABLE Libri (
    id INT PRIMARY KEY,
    titolo VARCHAR(100),
    autore VARCHAR(100),
    genere VARCHAR(50),
    prezzo DECIMAL(5,2),
    anno_pubblicazione INT
);
-- Inserimento dei libri nella tabella
INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione)
VALUES 
(1, 'Il nome della rosa', 'Umberto Eco', 'Storico', 14.90, 1980),
(2, '1984', 'George Orwell', 'Distopico', 12.50, 1949),
(3, 'Harry Potter e la pietra filosofale', 'J.K. Rowling', 'Fantasy', 16.99, 1997),
(4, 'Il piccolo principe', 'Antoine de Saint-Exupéry', 'Narrativa', 9.99, 1943),
(5, 'La coscienza di Zeno', 'Italo Svevo', 'Classico', 11.75, 1923),
(6, 'Orgoglio e pregiudizio', 'Jane Austen', 'Romantico', 10.50, 1813),
(7, 'Il confessore', 'Daniel Silva', 'Storico', 13.50, 2012),
(8, 'Il cerchio', 'Dave Eggers', 'Distopico', 15.90, 2014),
(9, 'Il fuoco', 'Elena Favilli', 'Fantasy', 17.20, 2018),
(10, 'Storia della mia ansia', 'Daria Bignardi', 'Narrativa', 12.80, 2019),
(11, 'Lacci', 'Domenico Starnone', 'Classico', 11.00, 2016),
(12, 'Io prima di te', 'Jojo Moyes', 'Romantico', 10.99, 2013);