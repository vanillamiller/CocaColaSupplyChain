package domain;
import auth.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CocaColaHQMapper {

    public static CocaColaHQ find(int id){

        CocaColaHQ result = new CocaColaHQ(id, "");
        IdentityMap<CocaColaHQ> map = IdentityMap.getInstance(result);
        result=map.get(id);

        if(result==null){
            String sql = "SELECT id, name FROM TRANSACTORS WHERE role='hq'";
            try (PreparedStatement sqlPrepared = DBConnection.prepare(sql)) {

//                sqlPrepared.setObject(1,"hq");
                ResultSet rs = sqlPrepared.executeQuery();
                rs.next();

                int CHQID = rs.getInt(1);
                String name = rs.getString(2);
                result = new CocaColaHQ(CHQID, name);
                map.put(id, result);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                System.out.println("coke hq not loading sql");
            }
        }
        return result;
    }


}
