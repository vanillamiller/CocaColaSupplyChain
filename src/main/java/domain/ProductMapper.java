package domain;

import auth.DBConnection;
import domain.Inventory;
import domain.Barrel;
import domain.Flavor;
import domain.Pallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ProductMapper {

    public static Inventory findall(int id){

        Inventory inv=new Inventory();
        String sql="SELECT id, form, flavor FROM Products WHERE location="+id;

        try {
            PreparedStatement stmt = DBConnection.prepare(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UUID pid= (UUID) rs.getObject(1);
                String form=rs.getString(2);
                String flavor=rs.getString(3);
                if(form.equals("barrel"))
                    inv.add(new Barrel(pid, Flavor.valueOf(flavor)));
                else
                    inv.add(new Pallet(pid, Flavor.valueOf(flavor)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here T6");
        }

        return inv;
    }

    public static void update(UUID pid, int to) throws SQLException {

        String sql="UPDATE products SET location="+to+"WHERE pid="+pid;

            PreparedStatement stmt=DBConnection.prepare(sql);
            stmt.execute();

    }

    public void delete() throws SQLException {

    }

    public static void insert(Created c) throws SQLException {

        Barrel barrel=(Barrel) c;
        UUID uuid = UUID.randomUUID();
        String sql="INSERT INTO Products(uuid, form, flavor, location) VALUES(?,?,?)";
        PreparedStatement stmt=DBConnection.prepare(sql);
        stmt.setObject(1,uuid);
        stmt.setString(2, "barrel");
        stmt.setString(3, barrel.getFlavor().toString());
        stmt.setInt(4,barrel.getTo());
        stmt.execute();
    }
}
