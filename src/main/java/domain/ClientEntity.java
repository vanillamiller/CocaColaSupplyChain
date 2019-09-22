package domain;

import java.sql.SQLException;

public interface ClientEntity {
    public boolean buy(int buyPallets, int DCId) throws SQLException;
}
