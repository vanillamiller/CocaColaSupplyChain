package domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import auth.DBConnection;

public class DCMapper {
    public static List<DC> findAllDCs() throws SQLException {
        List<DC> result = new ArrayList<>();
        String sql = "SELECT DCID, name, accountBookID, numPallets FROM DCs";
        try {
            PreparedStatement sqlPrepared = DBConnection.prepare(sql);
            ResultSet rs = sqlPrepared.executeQuery();

            while (rs.next()) {
                int DCID = rs.getInt(1);
                String name = rs.getString(2);
                int accountBookID = rs.getInt(3);
                int numPallets = rs.getInt(4);
                DC dc = new DC(DCID, name, accountBookID, numPallets);
                result.add(dc);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here D5");
        }
        System.out.println(result);
        return result;
    }

    public static DC findDC(int aDCID) throws SQLException {
        DC result = null;
        String sql = "SELECT DCID, name, accountBookID, numPallets FROM DCs WHERE DCID = ?";
        try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {
            sqlPrepared.setInt(1, aDCID);
            ResultSet rs = sqlPrepared.executeQuery();
            rs.next();
            int DCID = rs.getInt(1);
            String name = rs.getString(2);
            int accountBookID = rs.getInt(3);
            int numPallets = rs.getInt(4);
            result = new DC(DCID, name, accountBookID, numPallets);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here D3");
        }
        return result;
    }

    public static boolean updateDC(int DCID, int numPallets) throws SQLException {

        String sql = "UPDATE DCs SET numPallets = ? WHERE DCID = ?";
        try(PreparedStatement sqlPrepared = DBConnection.prepare(sql)){
            sqlPrepared.setInt(1, numPallets);
            sqlPrepared.setInt(2, DCID);
            int rs = sqlPrepared.executeUpdate();
            System.out.println("here is the int: DD " + rs);
            System.out.println("sqlPrepared");
            System.out.println(sqlPrepared);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here D4");
            return false;
        }
        return true;
    }
}



