-- SELECT * FROM DCs;
-- SELECT * FROM Retailers;
-- SELECT * FROM DCsRetailers;
-- SELECT * FROM Transactions;
-- SELECT * FROM Inventory;


INSERT INTO Transactions(
    numPallets,
    date,
    fromID,
    toID
)
VALUES
(2, CURRENT_TIMESTAMP, 1, 2)