package domain;

import auth.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DCToRetailerMapper {
    public static List<Integer> returnDCs(int aRetailerID) throws SQLException {
        List<Integer> result = new ArrayList<>();
        String sql = "SELECT DCID FROM DCsRetailers WHERE RetailerID = ?";
        try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {
            sqlPrepared.setInt(1, aRetailerID);
            ResultSet rs = sqlPrepared.executeQuery();
            while (rs.next()) {
                int DCID = rs.getInt(1);
//                int RetailerID = rs.getInt(2);
                result.add(DCID);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here DR5");
        }
        System.out.println(result);
        return result;
    }

}



