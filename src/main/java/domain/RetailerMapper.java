package domain;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.LinkedList;
        import java.util.List;
        import auth.DBConnection;

public class RetailerMapper {
    public static List<Retailer> findAllRetailers() throws SQLException {
        List<Retailer> result = new ArrayList<>();
        String sql = "SELECT retailerID, name, accountBookID, totalPalletsBought FROM Retailers";
        try {
            PreparedStatement sqlPrepared = DBConnection.prepare(sql);
            ResultSet rs = sqlPrepared.executeQuery();

            while (rs.next()) {
                int retailerID = rs.getInt(1);
                String name = rs.getString(2);
                int accountBookID = rs.getInt(3);
                int totalPalletsBought = rs.getInt(4);
                Retailer retailer = new Retailer(retailerID, name, accountBookID, totalPalletsBought);
                result.add(retailer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here R5");
        }
        System.out.println(result);
        return result;
    }


    public static Retailer findRetailer(int aRetailerID) throws SQLException {
        Retailer result = null;
        String sql = "SELECT retailerID, name, accountBookID, totalPalletsBought FROM Retailers WHERE RetailerID = ?";
        try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {
            sqlPrepared.setInt(1, aRetailerID);
            ResultSet rs = sqlPrepared.executeQuery();
            rs.next();
            int retailerID = rs.getInt(1);
            String name = rs.getString(2);
            int accountBookID = rs.getInt(3);
            int totalPalletsBought = rs.getInt(4);
            result = new Retailer(retailerID, name, accountBookID, totalPalletsBought);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here R3");
        }
        return result;
    }

    public static boolean updateRetailer(int retailerID, int totalPalletsBought) throws SQLException {

        String sql = "UPDATE Retailers SET totalPalletsBought = ? WHERE RetailerID = ?";
        try(PreparedStatement sqlPrepared = DBConnection.prepare(sql)){
            sqlPrepared.setInt(1, totalPalletsBought);
            sqlPrepared.setInt(2, retailerID);
            int rs = sqlPrepared.executeUpdate();
            System.out.println("here is the int: " + rs);
            System.out.println("sqlPrepared");
            System.out.println(sqlPrepared);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here R4");
            return false;
        }
        return true;
    }
}


//public class DBRetailerMapper {
//    public static List<Retailer> retailers;
//
//    public static List<Retailer> getAllretailers(){
//        if (retailers == null) {
//            retailers = new LinkedList<Retailer>();
//            retailers.add(new Retailer(0,"ColesMelbourne",0));
//            retailers.add(new Retailer(1,"ColesSydney",1));
//            retailers.add(new Retailer(2,"ColesBrisbane",2));
//            retailers.add(new Retailer(3,"ColesMelbourne2",3));
//        }
//        return retailers;
//    }
//    public static Retailer findretailer(int retailerID) {
//        for (Retailer ret: getAllretailers()) {
//            if (ret.getretailerID() == (retailerID)) {
//                return ret;
//            }
//        }
//        return null;
//    }
//
//}

