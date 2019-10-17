package domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import auth.DBConnection;

public class TransactionMapper {

    public static List<Transaction> findAll(int id) {

        List<Transaction> result = new ArrayList<>();
        String sql;
        sql = "SELECT id, date, fromid, toid FROM Transactions WHERE fromID=" + id+ "OR toID="+id;
        try {
            PreparedStatement stmt = DBConnection.prepare(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int txID = rs.getInt(1);
                int numPallets = rs.getInt(2);
                Date date = rs.getDate(3);
                int fromID = rs.getInt(4);
                int toID = rs.getInt(5);
                //Transaction tran = new Transaction(txID, order, date, fromID, toID);
                //result.add(tran);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here T6");
        }
        System.out.println(result);
        return result;
    }




    public static void insert(Created c) throws SQLException {
        Transaction tx=(Transaction) c;
        WriteLockManager wlm = WriteLockManager.getInstance();
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        Order order=tx.getOrder();
        int fromID=tx.getFrom();
        int toID=tx.getTo();
        UUID uuid= UUID.randomUUID();

        try {
            wlm.acquireWriteLock(tx);
            IdentityMap<Transaction> map = IdentityMap.getInstance(new Transaction());
//        String sql = "UPDATE Transactions set numPallets = ?, date = ?, fromID = ?, toID = ?";
            String sql = "INSERT INTO Transactions(numPallets, date, fromID, toID) VALUES (?, ?, ?, ?)";
//        PreparedStatement sqlPrepared = DBConnection.prepare(sql)
            PreparedStatement sqlPrepared = DBConnection.prepare(sql);
//            sqlPrepared.setInt(1, numPallets);
            sqlPrepared.setTimestamp(2, ts);
            sqlPrepared.setInt(3, fromID);
            sqlPrepared.setInt(4, toID);
            sqlPrepared.executeUpdate();
            System.out.println("sqlPrepared");
            System.out.println(sqlPrepared);
            System.out.println("transaction mapper uow working");
            wlm.releaseWriteLock(tx);
        }
        catch (SQLException |InterruptedException e) {
            e.printStackTrace();
        }
    }

//        public boolean update(Transactor t){
//
//        if (t instanceof DC)
//            t=(DC) t;
//        if (t instanceof Bottler)
//            t=(Bottler) t;
//        if (t instanceof CocaColaHQ)
//            t=(CocaColaHQ) t;
//        if (t instanceof Retailer)
//            t=(Retailer) t;
//
//        IdentityMap<Transactor> map = IdentityMap.getInstance(t);
//
//
//        String sql = "UPDATE Transactors SET numPallets = ? WHERE DCID = ?";
//        try(PreparedStatement sqlPrepared = DBConnection.prepare(sql)){
//            sqlPrepared.setInt(1, dc.getnumPallets());
//            sqlPrepared.setInt(2, dc.getID());
//            int rs = sqlPrepared.executeUpdate();
//            map.get(dc.getID()).setPallets(dc.getnumPallets());
//            System.out.println("here is the int: DD " + rs);
//            System.out.println("sqlPrepared");
//            System.out.println(sqlPrepared);
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//            System.out.println("here D4");
//            return false;
//        }
//        return true;
//    }
}

