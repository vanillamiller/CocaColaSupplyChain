package mappers;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;
        import auth.DBConnection;
        import domain.external.Retailer;
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

    public boolean update(Transactor t) {

        //IdentityMap<Retailer> map = IdentityMap.getInstance(new Retailer(0, "garbage"));
        Retailer r=(Retailer) t;
        String sql = "UPDATE Retailers SET totalPalletsBought = ? WHERE RetailerID = ?";
        try(PreparedStatement sqlPrepared = DBConnection.prepare(sql)){
            sqlPrepared.setInt(1, r.gettotalPalletsBought());
            sqlPrepared.setInt(2, r.getID());
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




