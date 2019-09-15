DROP TABLE DCs;
DROP TABLE Transactions;
DROP TABLE Inventory;
DROP TABLE AccountBooks;

CREATE TYPE vessel AS ENUM ('cans', 'bottles');
CREATE TYPE flavour AS ENUM ('regular', 'vanilla', 'zero');

CREATE TABLE DCs(
	DCId SERIAL PRIMARY KEY,
	name VARCHAR(50),
	accountBookID INTEGER,
	inventoryID INTEGER,
);


CREATE TABLE Transactions(
	txId SERIAL PRIMARY KEY,
	price money,
	palletID INTEGER,
	txTime TIMESTAMP,
	buyerID INTEGER,
	sellerID INTEGER
);


CREATE TABLE Inventory(
	itemId SERIAL PRIMARY KEY,
	vesselType vessel,
	flavourType flavour,
	ownerID INTEGER
);

CREATE TABLE AccountBooks(
	accountBookId SERIAL PRIMARY KEY
);

INSERT INTO DCs (
	name, 
	accountBookID,
	inventoryID
) 
VALUES 
('Melbourne', NULL, NULL),
('Sydney', NULL, NULL),
('Brisbane', NULL, NULL),
('Perth', NULL, NULL);



INSERT INTO Transactions (
	price,
	palletID,
	txTime,
	buyerID,
	sellerID
) 
VALUES 
(CURRENT_TIMESTAMP, '$22', 1, 3, 1),
(CURRENT_TIMESTAMP, '$11.89', 2, 2, 2),
(CURRENT_TIMESTAMP, '$0.921301', 3, 3, 2),
(CURRENT_TIMESTAMP, '$0.23', 4, 1, 4);


SELECT * FROM Transactions;