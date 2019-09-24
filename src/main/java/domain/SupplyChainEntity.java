package domain;

import java.sql.SQLException;

public interface SupplyChainEntity {
    public int ship(int shipPallets, int toID) throws SQLException;
}
