-- SELECT *
-- -- FROM   pg_stat_activity
-- -- WHERE  usename = 'user_name';

-- SELECT * FROM transactors;

SELECT * FROM TRANSACTORS LEFT JOIN TransactorRelations ON TRANSACTORS.id=TransactorRelations.fromid WHERE TransactorRelations.toid=1;