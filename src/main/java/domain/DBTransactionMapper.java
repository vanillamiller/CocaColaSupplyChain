package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import auth.DBConnection;

public class DBTransactionMapper {
    public static List<Transaction> findAllTransactions() throws SQLException {
        List<Transaction> result = new ArrayList<>();
        String sql = "SELECT txId, numPallets, txTime, sellerID, buyerID FROM Transactions";
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

        }
        System.out.println(result);
        return result;
    }

    public static void createTransaction(Transaction tran) throws SQLException {
        String sql = "UPDATE Transaction set numPallets = {}, date = {}, fromID = {}, toID = {}";
        PreparedStatement sqlPrepared = DBConnection.prepare(sql, tran.getNumPallets(), tran.getDate(), tran.getFrom(), tran.getTo());
        System.out.println(sql);
        System.out.println(sqlPrepared);
        sqlPrepared.executeQuery();
    }

    public static Transaction makeTransaction(int numPallets, int fromID, int toID) throws SQLException {
        //        TODO when makeTransaction is called, need to auto increment transaction ID.
        Date date = new Date();
        Transaction tran = new Transaction(numPallets,date,fromID,toID);
//        transactions.add(tran);
        createTransaction(tran);
        return null;
    }
}

