package domain;

import java.sql.SQLException;

public interface ClientEntity {
    public boolean buy(int buyPallets, int DCID) throws SQLException;
}
