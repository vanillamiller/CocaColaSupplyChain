DROP TABLE DCs;
DROP TABLE Retailers;
DROP TABLE DCsRetailers;
DROP TABLE Transactions;
DROP TABLE Inventory;

DROP TYPE colaForm;

CREATE TYPE colaForm AS ENUM ('syrup', 'pallet');

CREATE TABLE DCs(
    DCId SERIAL PRIMARY KEY,
    name VARCHAR(50),
    accountBookID INTEGER,
    numPallets INTEGER
);

CREATE TABLE Retailers(
    RetailerId SERIAL PRIMARY KEY,
    name VARCHAR(50),
    accountBookID INTEGER,
    totalPalletsBought INTEGER
);


CREATE TABLE DCsRetailers(
     DCRetailerId SERIAL PRIMARY KEY,
     DCId INTEGER,
     RetailerId INTEGER
);


CREATE TABLE Transactions(
    txId SERIAL PRIMARY KEY,
    numPallets INTEGER,
    txTime TIMESTAMP,
    fromID INTEGER,
    toID INTEGER
);


-- CREATE TABLE Inventory(
-- 	inventoryID SERIAL PRIMARY KEY,
-- 	DCId INTEGER,
-- 	sold BOOLEAN
-- );



-- POPULATE WITH DUMMY DATA --



INSERT INTO DCs(
    name,
    accountBookID,
    numPallets
)
VALUES
('Melbourne DC',0,20),
('Sydney DC',1,30),
('Brisbane DC',2,10),
('Perth DC',3,232);

INSERT INTO Retailers(
    name,
    accountBookID,
    totalPalletsBought
)
VALUES
('Coles Collingwood',11,0),
('Coles Fitzroy',12,0),
('Coles Sydney',13,0),
('Coles Perth',14,0);


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
    numPallets,
    txTime,
    fromID,
    toID
)
VALUES
(2, CURRENT_TIMESTAMP, 1, 2),
(7, CURRENT_TIMESTAMP, 2, 3),
(7, CURRENT_TIMESTAMP, 1, 2),
(3, CURRENT_TIMESTAMP, 4, 4),
(6, CURRENT_TIMESTAMP, 1, 1),
(8, CURRENT_TIMESTAMP, 2, 3),
(1, CURRENT_TIMESTAMP, 1, 2),
(23, CURRENT_TIMESTAMP, 1, 2);


-- INSERT INTO Inventory(
--     DCId,
--     sold
-- )
-- VALUES
-- (1,true),
-- (2,true),
-- (3,true),
-- (4,true),
-- (5,true),
-- (6,true),
-- (7,true),
-- (8,true),
-- (9,false),
-- (10,false),
-- (11,false),
-- (12,false),
-- (13,false),
-- (14,false);