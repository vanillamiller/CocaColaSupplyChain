package domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import auth.DBConnection;
import mappers.IdentityMap;

public class TransactionMapper {

    public static List<Transaction> findAllTransactions() throws SQLException {

        List<Transaction> result = new ArrayList<>();

        String sql = "SELECT txID, numPallets, date, fromID, toID FROM Transactions";
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


    public static boolean makeTransaction(int numPallets, int fromID, int toID) throws SQLException {
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());

//        String sql = "UPDATE Transactions set numPallets = ?, date = ?, fromID = ?, toID = ?";
        String sql = "INSERT INTO Transactions(numPallets, date, fromID, toID) VALUES (?, ?, ?, ?)";
        try(PreparedStatement sqlPrepared = DBConnection.prepare(sql)){
            sqlPrepared.setInt(1, numPallets);
            sqlPrepared.setTimestamp(2, ts);
            sqlPrepared.setInt(3, fromID);
            sqlPrepared.setInt(4, toID);
            sqlPrepared.executeUpdate();
            System.out.println("sqlPrepared");
            System.out.println(sqlPrepared);
        }
         catch (SQLException e) {
            System.out.println(e.getMessage());
             System.out.println("here T5");
            return false;
        }
        return true;
    }
}

