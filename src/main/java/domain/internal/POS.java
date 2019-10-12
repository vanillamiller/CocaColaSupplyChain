package domain.internal;

import java.sql.SQLException;

public interface POS extends Sends, Receives {

    public boolean ship(int shipPallets, int toID) throws SQLException;

    public boolean restockPallets(int restockPallets) throws SQLException;

}
