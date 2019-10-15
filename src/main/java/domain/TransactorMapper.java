package domain;

import auth.DBConnection;
import domain.Transactor;
import domain.Retailer;
import domain.Bottler;
import domain.CocaColaHQ;
import domain.DC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactorMapper {

    public static Transactor find(String username){

            String sql = "SELECT id, name, role, password FROM Transactors WHERE username = ?";
            Transactor result;
            try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {

                sqlPrepared.setString(1, username);
                System.out.println("here in sql statement prepared");
                ResultSet rs = sqlPrepared.executeQuery();
                rs.next();

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role=rs.getString("role");
                String password=rs.getString("password");

                switch(role){
                    case "hq":
                        result=new CocaColaHQ(id, name);
                        result.setPassword(password);
                        result.setUsername(username);
                        return result;

                    case "dc":
                        result=new DC(id, name);
                        result.setPassword(password);
                        result.setUsername(username);
                        return result;

                    case "cli":
                        result=new Retailer(id, name);
                        result.setPassword(password);
                        result.setUsername(username);

                    case "bot":
                        result=new Bottler(id, name);
                        result.setPassword(password);
                        result.setUsername(username);

                }

                System.out.println(name + "dc gone thru idMap");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("here D3");
            }

        return null;

    }

    public static Transactor find(int id){

            String sql = "SELECT id, name, role FROM Transactors WHERE id ="+id;

            try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {

                ResultSet rs = sqlPrepared.executeQuery();
                rs.next();
                String name = rs.getString(2);
                String role=rs.getString(3);

                switch(role){
                    case "hq":
                        return new CocaColaHQ(id, name);
                    case "dc":
                        return new DC(id, name);
                    case "cli":
                        return new Retailer(id, name);
                    case "bot":
                        return new Bottler(id, name);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("COULDN'T FIND TRANSACTOR BY ID");
            }

        return null;
    }

    public static List<Transactor> findall(String role){

        List<Transactor> result = new ArrayList<>();
        String sql = "SELECT id, name FROM Transactors WHERE role="+role+" ORDER BY name ASC";

        try {
            Transactor current=null;
            PreparedStatement sqlPrepared = DBConnection.prepare(sql);
            ResultSet rs = sqlPrepared.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);

                switch(role){
                    case "hq":
                        current=new CocaColaHQ(id, name);
                        break;
                    case "dc":
                        current=new DC(id, name);
                    case "cli":
                        current=new Retailer(id, name);
                    case "bot":
                        current=new Bottler(id, name);
                }
                result.add(current);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("COULDNT FIND ALL TRANSACTORS BY ROLE: "+role);
        }
        System.out.println(result);
        return result;

    }

    public static void update(Transactor t){

    }
}
