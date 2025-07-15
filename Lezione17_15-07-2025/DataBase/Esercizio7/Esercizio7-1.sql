-- Creazione della tabella Clienti
CREATE TABLE Cli (
    id INT,
    nome VARCHAR(100),
    città VARCHAR(100)
);
-- inserimento dei clienti
INSERT INTO Cli (id, nome, città) VALUES
(1, 'Alessandro Rossi', 'Roma'),
(2, 'Giulia Bianchi', 'Milano'),
(3, 'Marco Verdi', 'Napoli'),
(4, 'Anna Neri', 'Torino'),
(5, 'Luca Costa', 'Firenze'),
(6, 'Francesca Lanza', 'Bologna'),
(7, 'Davide Ferri', 'Genova'),
(8, 'Marta Greco', 'Palermo'),
(9, 'Andrea Santi', 'Cagliari'),
(10, 'Sara Colle', 'Bari'),
(11, 'Claudio Nanni', 'Roma'),
(12, 'Angela Zitti', 'Milano'),
(13, 'Antonio Bruni', 'Napoli'),
(14, 'Arianna Serra', 'Torino'),
(15, 'Federico Conte', 'Firenze'),
(16, 'Elisa Romano', 'Bologna'),
(17, 'Giovanni Morea', 'Genova'),
(18, 'Simone D’Angelo', 'Palermo'),
(19, 'Laura Vitale', 'Cagliari'),
(20, 'Riccardo Fonti', 'Bari');

-- creazione della tabella ordini
CREATE TABLE Ordini (
    id INT,
    id_cliente INT,
    data_ordine DATE,
    importo DECIMAL(7,2)
);
-- inserimento degli ordini
INSERT INTO Ordini (id, id_cliente, data_ordine, importo) VALUES
(1, 1, '2025-06-01', 150.00),
(2, 2, '2025-06-03', 89.99),
(3, 3, '2025-06-04', 45.50),
(4, 4, '2025-06-05', 210.75),
(5, 1, '2025-06-06', 120.00),
(6, 6, '2025-06-06', 75.25),
(7, 7, '2025-06-07', 50.00),
(8, 2, '2025-06-08', 180.10),
(9, 2, '2025-06-08', 98.99),
(10, 10, '2025-06-09', 130.00),
(11, 10, '2025-06-10', 105.00),
(12, 12, '2025-06-10', 60.45),
(13, 13, '2025-06-11', 205.00),
(14, 14, '2025-06-11', 90.00),
(15, 15, '2025-06-12', 150.00),
(16, 16, '2025-06-13', 70.00),
(17, 17, '2025-06-14', 115.00),
(18, 18, '2025-06-14', 220.00),
(19, 20, '2025-06-15', 199.99),
(20, 20, '2025-06-16', 85.00),
(21, NULL, '2025-07-01', 99.99);