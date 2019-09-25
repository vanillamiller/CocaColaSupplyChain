package mappers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import auth.DBConnection;
import domain.DC;
import domain.Transaction;
import mappers.IdentityMap;

public class DCMapper {

    public static List<DC> findAll() {

        List<DC> result = new ArrayList<>();
        String sql = "SELECT DCID, name, accountBookID, numPallets FROM DCs ORDER BY name ASC";

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

    public static List<DC> findMyDCs(int aRetailerID) throws SQLException {
        List<DC> result = new ArrayList<>();
        System.out.println("here D9");
        String sql = "SELECT DCs.DCID, DCs.name, DCs.accountBookID, DCs.numPallets from DCsRetailers NATURAL JOIN DCs where RetailerID = ?";
        try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {
            sqlPrepared.setInt(1, aRetailerID);
            ResultSet rs = sqlPrepared.executeQuery();
            System.out.println("here D10");
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
            System.out.println("here D8");
        }
        System.out.println(result);
        return result;
    }

    public static DC find(int aDCID) throws SQLException {

        DC result = new DC(aDCID, "");
        IdentityMap<DC> map = IdentityMap.getInstance(result);
        result = map.get(aDCID);

        if(result==null) {
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
                map.put(aDCID, result);
                System.out.println(aDCID + "dc gone thru idMap");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("here D3");
            }
        } else {
                System.out.println(aDCID + "dc already in dc map");
        }
        return result;
    }

    public static boolean update(int DCID, int numPallets) throws SQLException {

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



