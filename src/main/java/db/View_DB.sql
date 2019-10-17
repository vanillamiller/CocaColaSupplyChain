-- SELECT * FROM DCs;
-- SELECT * FROM Retailers;
-- SELECT * FROM DCsRetailers;
-- SELECT * FROM Transactions;
-- SELECT * FROM Inventory;

--
-- INSERT INTO Transactions WHER

SELECT id, name, role, password FROM Transactors WHERE username ='melbdc';

SELECT id, name, role FROM Transactors WHERE id=(SELECT fromID FROM TransactorMapper WHERE toID=1);