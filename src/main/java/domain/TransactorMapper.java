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
            Transactor result = null;
            try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {

                sqlPrepared.setString(1, username);
                System.out.println("here in sql statement prepared");
                ResultSet rs = sqlPrepared.executeQuery();
                rs.next();

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role=rs.getString("role");
                String password=rs.getString("password");
                System.out.println("in transactor mapper find string, just getting name: " + name + " and role: " + role);

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

                    case "cl":
                        result=new Retailer(id, name);
                        result.setPassword(password);
                        result.setUsername(username);
                        System.out.println("HERE WE ARE CL IN TRANSACTION MAPPER STRING");
                        return result;

                    case "bt":
                        result=new Bottler(id, name);
                        result.setPassword(password);
                        result.setUsername(username);
                        System.out.println("HERE WE ARE BT IN TRANSACTION MAPPER STRING");
                        return result;
                }

                System.out.println(name + " gone thru idMap");
                return result;
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
                System.out.println("in transactor mapper find int, just getting name: " + name + " and role: " + role);
                switch(role){
                    case "hq":
                        return new CocaColaHQ(id, name);
                    case "dc":
                        return new DC(id, name);
                    case "cl":
                        return new Retailer(id, name);
                    case "bt":
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
                    case "cl":
                        current=new Retailer(id, name);
                    case "bt":
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


    public static List<Transactor> getall(){

        List<Transactor> result = new ArrayList<>();
        String sql = "SELECT id, name, role FROM Transactors ORDER BY name ASC";

        try {
            Transactor current=null;
            PreparedStatement sqlPrepared = DBConnection.prepare(sql);
            ResultSet rs = sqlPrepared.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                String role = rs.getString(2);


                switch(role){
                    case "hq":
                        current=new CocaColaHQ(id, name);
                    case "dc":
                        current=new DC(id, name);
                    case "cl":
                        current=new Retailer(id, name);
                    case "bt":
                        current=new Bottler(id, name);
                }
                result.add(current);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("COULDNT GETALL TRANSACTORS");
        }
        System.out.println(result);
        return result;

    }


    public static List<Transactor> findMyTransactors(int toID){

        List<Transactor> result = new ArrayList<>();
        String sql = "SELECT * FROM TRANSACTORS LEFT JOIN TransactorRelations ON TRANSACTORS.id=TransactorRelations.fromid WHERE TransactorRelations.toid=" + toID + ";";


        try {
            Transactor current=null;
            PreparedStatement sqlPrepared = DBConnection.prepare(sql);
            ResultSet rs = sqlPrepared.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                String name = rs.getString(2);
                String role = rs.getString(3);

                switch(role){
                    case "hq":
                        current=new CocaColaHQ(id, name);
                        break;
                    case "dc":
                        current=new DC(id, name);
                    case "cl":
                        current=new Retailer(id, name);
                    case "bt":
                        current=new Bottler(id, name);
                }
                result.add(current);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("COULDNT FIND THIS TRANSACTORS PARENTS");
        }
        System.out.println(result);
        return result;

    }


    public static void update(Transactor t){

    }
}
