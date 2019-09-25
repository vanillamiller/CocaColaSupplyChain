package mappers;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.LinkedList;
        import java.util.List;
        import auth.DBConnection;
        import domain.DC;
        import domain.Retailer;
        import domain.Transactor;

public class RetailerMapper extends TransactorMapper {

    public List<Retailer> findAll() {
        List<Retailer> result = new ArrayList<>();
        String sql = "SELECT retailerID, name, accountBookID, totalPalletsBought FROM Retailers";
        IdentityMap<Retailer> map = IdentityMap.getInstance(new Retailer(0,"garbage"));

        try {
            PreparedStatement sqlPrepared = DBConnection.prepare(sql);
            ResultSet rs = sqlPrepared.executeQuery();

            while (rs.next()) {
                int retailerID = rs.getInt(1);
                String name = rs.getString(2);
                int accountBookID = rs.getInt(3);
                int totalPalletsBought = rs.getInt(4);
                Retailer retailer = new Retailer(retailerID, name, accountBookID, totalPalletsBought);
                map.put(retailerID, retailer);
                result.add(retailer);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here R5");
        }
        System.out.println(result);
        return result;
    }


    public Retailer find(int id) {

        Retailer result = new Retailer(id, "");
        IdentityMap<Retailer> map = IdentityMap.getInstance(result);
        result = map.get(id);
        String sql = "SELECT retailerID, name, accountBookID, totalPalletsBought FROM Retailers WHERE RetailerID = ?";

        if(result==null) {
            try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {
                sqlPrepared.setInt(1, id);
                ResultSet rs = sqlPrepared.executeQuery();
                rs.next();
                int retailerID = rs.getInt(1);
                String name = rs.getString(2);
                int accountBookID = rs.getInt(3);
                int totalPalletsBought = rs.getInt(4);
                System.out.println(id+" ret thru id map");
                result = new Retailer(retailerID, name, accountBookID, totalPalletsBought);
                map.put(id, result);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("here R3");
            }
        } else {
            System.out.println(id+" already in id map");
        }
        return result;
    }

    public boolean update(int id, int numPallets) {

        //IdentityMap<Retailer> map = IdentityMap.getInstance(new Retailer(0, "garbage"));

        String sql = "UPDATE Retailers SET totalPalletsBought = ? WHERE RetailerID = ?";
        try(PreparedStatement sqlPrepared = DBConnection.prepare(sql)){
            sqlPrepared.setInt(1, numPallets);
            sqlPrepared.setInt(2, id);
            int rs = sqlPrepared.executeUpdate();
            //map.get(retailerID).
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

