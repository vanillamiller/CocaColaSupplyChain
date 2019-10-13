DROP TABLE Order;
DROP TABLE Transactions;
DROP TABLE Inventory;
DROP TABLE Transactors;
DROP TABLE TransactorMapper;

CREATE TYPE roletype AS ENUM ('dc', 'cl','hq','bt');

CREATE TABLE Transactors(

    ID SERIAL PRIMARY KEY,
    name VARCHAR(50),

    role roletype NOT NULL,
    username VARCHAR(24) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE Inventory(
    transactorID INTEGER REFERENCES Transactors(ID),
    numregular INTEGER,
    numvanilla INTEGER,
    numzero INTEGER
);

CREATE TABLE TransactorMapper(
     fromID INTEGER,
     toID INTEGER
);

CREATE TABLE Transactions(
    txID SERIAL PRIMARY KEY,
    business BOOLEAN NOT NULL,
    price money,
    order INTEGER,
    date TIMESTAMP,
    fromID INTEGER,
    toID INTEGER
);

CREATE TABLE Order(
    txID INTEGER REFERENCES Transactions(txID),
    numregular INTEGER,
    numvanilla INTEGER,
    numzero INTEGER
);

-- POPULATE WITH DUMMY DATA --

INSERT INTO Transactors(
    name,
    role,
    username,
    password
)
VALUES
--dcs
('Melbourne DC','dc','melbdc','a'),
('Sydney DC','dc','syddc','a'),
('Brisbane DC','dc','brisdc','a'),
('Perth DC','dc','perthdc','a'),
--clients
('Coles Collingwood','cl','colescoll','a'),
('Coles Fitzroy','cl','colesfitz','a'),
('Coles Sydney','cl','colessyd','a'),
('Coles Perth','cl','colesperth','a'),
--factory
('HQ Syrup Factory','hq','syrup factory hq','a'),
--bottling plants
('Melbourne bottling plant','bt','melbbot','a'),
('Sydney bottling plant','bt','sydbot','a');

INSERT INTO Inventory(
    transactorID
)
VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11);

INSERT INTO TransactorMapper(
    fromID,
    toID
)
VALUES
(1,5),
(1,6),
(2,7),
(3,5),
(4,8),
(9,10),
(9,11),
(10,1),
(10,3),
(10,4),
(11,2),
(11,3);
