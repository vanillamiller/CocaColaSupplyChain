
DROP TABLE Transactors CASCADE;
DROP TABLE TransactorRelations CASCADE;
DROP TABLE Transactions CASCADE;
DROP TABLE Products CASCADE;
DROP TABLE Orders CASCADE;



CREATE TYPE roletype AS ENUM ('dc', 'cl','hq','bt');
CREATE TYPE form AS ENUM('barrel','pallet');
CREATE TYPE flavor AS ENUM ('REGULAR','VANILLA','ZERO');

CREATE TABLE Transactors(
    --basic
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    --auth credentials
    role roletype NOT NULL,
    username VARCHAR(24) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE TransactorRelations(
     fromID INTEGER REFERENCES Transactors(id),
     toID INTEGER REFERENCES Transactors(id)
);

CREATE TABLE Transactions(
    id uuid PRIMARY KEY,
    business BOOLEAN NOT NULL,
    price INTEGER,
--     order INTEGER,
    date TIMESTAMP,
    fromID INTEGER,
    toID INTEGER
);

CREATE TABLE Products(
    id uuid PRIMARY KEY,
    form form NOT NULL,
    flavor flavor NOT NULL,
    location INTEGER REFERENCES Transactors(id) NOT NULL
);

CREATE TABLE Orders(
    txID uuid REFERENCES Transactions(id),
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
('Coles Brisbane','cl','colesbris','a'),
--factory
('HQ Syrup Factory','hq','syruphq','a'),
--bottling plants
('Melbourne bottling plant','bt','melbbot','a'),
('Sydney bottling plant','bt','sydbot','a');

INSERT INTO TransactorRelations(
    fromID,
    toID
)
VALUES
(10,11),
(10,12),
(11, 1),
(11, 4),
(12, 2),
(12, 3),
(1, 5),
(1, 6),
(2, 7),
(3, 9),
(4, 8);
