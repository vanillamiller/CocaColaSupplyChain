package mappers;

import auth.DBConnection;
import domain.Transaction;
import domain.internal.Inventory;
import domain.products.Barrel;
import domain.products.Flavor;
import domain.products.Pallet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ProductMapper {

    public Inventory findall(int id){

        Inventory inv=new Inventory();
        String sql="SELECT id, form, flavor FROM Products WHERE location="+id;

        try {
            PreparedStatement stmt = DBConnection.prepare(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int pid=rs.getInt(1);
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

    public void update() throws SQLException {

    }

    public void delete() throws SQLException {

    }
}
