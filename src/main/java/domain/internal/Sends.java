package domain.internal;

import java.sql.SQLException;

public interface Sends {
    public boolean ship(int shipPallets, int toID) throws SQLException;
}
