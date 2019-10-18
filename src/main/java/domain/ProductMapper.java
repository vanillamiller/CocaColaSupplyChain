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
        System.out.println("this is the inv HERE!)!)!)!)!)!)!:::: " + inv);
        String sql="SELECT id, form, flavor FROM Products WHERE location="+id;

        try {
            PreparedStatement stmt = DBConnection.prepare(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("EACH INVENTORY ITEM HERE");
                UUID pid= (UUID) rs.getObject(1);
                String form=rs.getString(2);
                String flavor=rs.getString(3);
//                if(form.equals("barrel"))
//                    inv.add(new Barrel(pid, Flavor.valueOf(flavor)));
//                else

                // create pallet from DB
                Pallet p = new Pallet(pid, Flavor.valueOf(flavor));
                // convert pallet to product
//                Product p2 = p;
                // add product to inv
                inv.add(p);
//                System.out.println(inv.num_regular());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("here T6");
        }

        return inv;
    }

    public static void update(UUID pid, int to) throws SQLException {

        String sql="UPDATE products SET location=? WHERE id=?";

        PreparedStatement stmt=DBConnection.prepare(sql);
        stmt.setInt(1,to);
        stmt.setObject(2, pid);
        System.out.println("HERE WE ARE IN PRODUCT MAPPER THISFHUdfsfshf");
        stmt.execute();

    }

    public void delete() throws SQLException {

    }

    public static void insert(Created c) throws SQLException {
        System.out.println("HERE WE ARE IN PRODUCT MAPPER");
        Pallet p = (Pallet) c;
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(p.getTo());
        String sql="INSERT INTO Products(id, form, flavor, location) VALUES(?,?::form,?::flavor,?)";
        PreparedStatement stmt=DBConnection.prepare(sql);
        stmt.setObject(1,uuid);
        stmt.setObject(2, "pallet");
        System.out.println("just writing this in the insert : "+ p.getFlavor().toString());
        stmt.setObject(3, p.getFlavor().toString());
        stmt.setInt(4,p.getTo());
        stmt.execute();

    }
}
