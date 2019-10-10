package domain;

import java.sql.SQLException;

public interface SupplyChainEntity {
    public boolean ship(int shipPallets, int toID) throws SQLException;
}
