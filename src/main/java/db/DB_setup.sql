DROP TABLE Order;
DROP TABLE Transactions;
DROP TABLE Transactors;
DROP TABLE TransactorMapper;

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

CREATE TABLE TransactorMapper(
     fromID INTEGER,
     toID INTEGER
);

CREATE TABLE Transactions(
    id uuid PRIMARY KEY,
    business BOOLEAN NOT NULL,
    price money,
    order INTEGER,
    date TIMESTAMP,
    fromID INTEGER,
    toID INTEGER
);

CREATE TABLE Products(
    id uuid PRIMARY KEY,
    form form NOT NULL,
    flavor flavor NOT NULL,
    location INTEGER REFERENCES Transactors(id)
);

CREATE TABLE Order(
    txID INTEGER REFERENCES Transactions(id),
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
