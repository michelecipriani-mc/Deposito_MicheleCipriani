-- creazione della tabella
CREATE TABLE Vendite (
    id INT,
    prodotto VARCHAR(100),
    categoria VARCHAR(50),
    quantita INT,
    prezzo_unitario DECIMAL(6,2),
    data_vendita DATE
);

-- Inserimento delle instanze
INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita)
VALUES
(1, 'Laptop Lenovo ThinkPad', 'Informatica', 3, 799.99, '2021-03-15'),
(2, 'Smartphone Samsung A52', 'Telefonia', 5, 299.99, '2021-05-20'),
(3, 'Stampante Epson EcoTank', 'Periferiche', 2, 189.50, '2021-06-10'),
(4, 'Monitor LG 27"', 'Periferiche', 4, 229.00, '2021-07-05'),
(5, 'Tastiera Logitech K380', 'Accessori', 6, 45.90, '2021-08-17'),
(6, 'Mouse Wireless HP', 'Accessori', 10, 25.99, '2021-10-03'),
(7, 'Router TP-Link Archer', 'Rete', 3, 89.99, '2021-11-11'),
(8, 'Notebook HP Envy', 'Informatica', 2, 999.00, '2022-01-14'),
(9, 'iPhone 13', 'Telefonia', 1, 899.99, '2022-02-22'),
(10, 'Tablet Samsung Galaxy Tab S6', 'Telefonia', 2, 449.90, '2022-03-10'),
(11, 'SSD Samsung 1TB', 'Componenti', 5, 129.99, '2022-04-30'),
(12, 'Scheda Video NVIDIA RTX 3060', 'Componenti', 2, 349.99, '2022-06-25'),
(13, 'Switch Netgear 8 porte', 'Rete', 4, 59.99, '2022-07-20'),
(14, 'Auricolari Sony WH-CH520', 'Accessori', 8, 49.90, '2022-09-18'),
(15, 'Monitor Samsung 32"', 'Periferiche', 3, 269.00, '2023-01-05'),
(16, 'Power Bank Anker 20000mAh', 'Accessori', 6, 39.90, '2023-02-12'),
(17, 'MacBook Air M2', 'Informatica', 1, 1249.00, '2023-03-19'),
(18, 'Rete Mesh Deco X20', 'Rete', 2, 199.00, '2023-04-04'),
(19, 'Hard Disk Esterno WD 2TB', 'Componenti', 3, 79.90, '2024-01-10'),
(20, 'Smartwatch Garmin Venu Sq', 'Telefonia', 2, 179.99, '2024-03-22');