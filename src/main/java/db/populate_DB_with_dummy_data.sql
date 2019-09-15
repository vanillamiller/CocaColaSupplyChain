INSERT INTO Transactions (
	txTime, 
	itemID,
	sellerID,
	buyerID
) 
VALUES 
(CURRENT_TIMESTAMP, 1, 3, 1),
(CURRENT_TIMESTAMP, 2, 2, 2),
(CURRENT_TIMESTAMP, 3, 3, 2),
(CURRENT_TIMESTAMP, 4, 1, 4);


SELECT * FROM Transactions;


