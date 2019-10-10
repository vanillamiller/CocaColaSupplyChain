package domain;

import java.sql.SQLException;

public interface SupplyChainEntity {
    public void ship(int shipPallets, int toID) throws SQLException;
}
