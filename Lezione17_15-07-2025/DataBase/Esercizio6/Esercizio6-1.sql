-- CREAZIONE NUOVA TABELLA CLIENTI
CREATE TABLE Clienti (
    id INT,
    nome VARCHAR(100),
    cognome VARCHAR(100),
    email VARCHAR(100),
    eta INT,
    citta VARCHAR(100)
);
-- inserimento in tabella 
INSERT INTO Clienti (id, nome, cognome, email, eta, citta) VALUES
(1, 'Alessandro', 'Rossi', 'alessandro.rossi@gmail.com', 35, 'Roma'),
(2, 'Anna', 'Bianchi', 'anna.bianchi@yahoo.com', 28, 'Milano'),
(3, 'Marco', 'Verdi', 'marco.verdi@gmail.com', 42, 'Napoli'),
(4, 'Giulia', 'Neri', 'giulia.neri@hotmail.com', 31, 'Torino'),
(5, 'Andrea', 'Santi', 'andrea.santi@gmail.com', 38, 'Roma Nord'),
(6, 'Luca', 'Costa', 'luca.costa@outlook.com', 29, 'Bologna'),
(7, 'Alberto', 'Ferri', 'alberto.ferri@gmail.com', 33, 'Palermo'),
(8, 'Sara', 'Colle', 'sara.colle@gmail.com', 27, 'Roma Est'),
(9, 'Paolo', 'Toni', 'paolo.toni@gmail.com', 30, 'Firenze'),
(10, 'Giovanni', 'Morea', 'giovanni.morea@libero.it', 41, 'Verona'),
(11, 'Francesca', 'Lanza', 'francesca.lanza@gmail.com', 36, 'Roma'),
(12, 'Antonio', 'Bruni', 'antonio.bruni@gmail.com', 45, 'Napoli'),
(13, 'Marta', 'Greco', 'marta.greco@gmail.com', 32, 'Genova'),
(14, 'Davide', 'Lopez', 'davide.lopez@gmail.com', 25, 'Roma'),
(15, 'Angela', 'Zitti', 'angela.zitti@gmail.com', 39, 'Torino'),
(16, 'Alina', 'Zappa', 'alina.zappa@yahoo.com', 34, 'Rovigo'),
(17, 'Claudio', 'Nanni', 'claudio.nanni@gmail.com', 40, 'Roma Sud'),
(18, 'Alessia', 'Matti', 'alessia.matti@gmail.com', 26, 'Trento'),
(19, 'Federico', 'Conte', 'federico.conte@live.it', 30, 'Roma Centro'),
(20, 'Arianna', 'Serra', 'arianna.serra@gmail.com', 37, 'Padova');