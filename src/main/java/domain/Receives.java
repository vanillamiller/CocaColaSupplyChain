package domain;

import java.sql.SQLException;

public interface Receives {
    public boolean restock(int shipPallets, int fromID) throws SQLException;

}
