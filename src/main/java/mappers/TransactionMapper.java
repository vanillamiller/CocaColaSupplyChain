package mappers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import auth.DBConnection;
import domain.Transaction;
import mappers.IdentityMap;

public class TransactionMapper {

    public static List<Transaction> findAll(int id, String dcOrRet) {

        List<Transaction> result = new ArrayList<>();
        String sql;

        if(dcOrRet.equals("DC")) {
            sql = "SELECT txID, numPallets, date, fromID, toID FROM Transactions WHERE fromID="+id;
        } else {
            sql = "SELECT txID, numPallets, date, fromID, toID FROM Transactions WHERE toID="+id;
        }

        try {

            PreparedStatement stmt = DBConnection.prepare(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int txID = rs.getInt(1);
                int numPallets = rs.getInt(2);
                Date date = rs.getDate(3);
                int fromID = rs.getInt(4);
                int toID = rs.getInt(5);
                Transaction tran = new Transaction(txID, numPallets, date, fromID, toID);
                result.add(tran);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here T6");
        }
        System.out.println(result);
        return result;
    }

    public static void insert(Transaction tx) throws SQLException {

        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        int numPallets=tx.getNumPallets();
        int fromID=tx.getFrom();
        int toID=tx.getTo();

        IdentityMap<Transaction> map = IdentityMap.getInstance(new Transaction());
//        String sql = "UPDATE Transactions set numPallets = ?, date = ?, fromID = ?, toID = ?";
        String sql = "INSERT INTO Transactions(numPallets, date, fromID, toID) VALUES (?, ?, ?, ?)";
//        PreparedStatement sqlPrepared = DBConnection.prepare(sql)
            PreparedStatement sqlPrepared = DBConnection.prepare(sql);
            sqlPrepared.setInt(1, numPallets);
            sqlPrepared.setTimestamp(2, ts);
            sqlPrepared.setInt(3, fromID);
            sqlPrepared.setInt(4, toID);
            sqlPrepared.executeUpdate();
            System.out.println("sqlPrepared");
            System.out.println(sqlPrepared);
            System.out.println("transaction mapper uow working");
    }
}

