DROP TABLE DCs;
DROP TABLE Retailers;
DROP TABLE DCsRetailers;
DROP TABLE Transactions;
DROP TABLE Inventory;

DROP TYPE colaForm;

CREATE TYPE colaForm AS ENUM ('syrup', 'pallet');

CREATE TABLE DCs(
	DCId SERIAL PRIMARY KEY,
	name VARCHAR(50)
);

CREATE TABLE Retailers(
	RetailerId SERIAL PRIMARY KEY,
	name VARCHAR(50)
);


CREATE TABLE DCsRetailers(
	DCRetailerId SERIAL PRIMARY KEY,
	DCId INTEGER,
	RetailerId INTEGER
);


CREATE TABLE Transactions(
	txId SERIAL PRIMARY KEY,
	price money,
	inventoryID INTEGER,
	txTime TIMESTAMP,
	sellerID INTEGER,
	buyerID INTEGER
);


CREATE TABLE Inventory(
	inventoryID SERIAL PRIMARY KEY,
	DCId INTEGER,
	sold BOOLEAN
);



-- POPULATE WITH DUMMY DATA --



INSERT INTO DCs(
	name
)
VALUES
('Melbourne DC'),
('Sydney DC'),
('Brisbane DC'),
('Perth DC');

INSERT INTO Retailers(
    name
)
VALUES
('Coles Collingwood'),
('Coles Fitzroy'),
('Coles Sydney'),
('Coles Perth');


INSERT INTO DCsRetailers(
    DCId,
    RetailerId
)
VALUES
(1,1),
(1,2),
(2,3),
(4,4);


INSERT INTO Transactions(
    price,
    inventoryID,
    txTime,
    sellerID,
    buyerID
)
VALUES
('$220', 1, CURRENT_TIMESTAMP, 1, 2),
('$333', 2, CURRENT_TIMESTAMP, 2, 3),
('$102', 3, CURRENT_TIMESTAMP, 1, 2),
('$50.25', 4, CURRENT_TIMESTAMP, 4, 4),
('$253', 5, CURRENT_TIMESTAMP, 1, 1),
('$132', 6, CURRENT_TIMESTAMP, 2, 3),
('$425', 7, CURRENT_TIMESTAMP, 1, 2),
('$80.5', 8, CURRENT_TIMESTAMP, 1, 2);


INSERT INTO Inventory(
    DCId,
    sold
)
VALUES
(1,true),
(2,true),
(3,true),
(4,true),
(5,true),
(6,true),
(7,true),
(8,true),
(9,false),
(10,false),
(11,false),
(12,false),
(13,false),
(14,false);