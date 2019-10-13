package domain.external;

import java.sql.SQLException;

public interface ClientEntity {
    public boolean buy(int buyPallets, int DCID);
}
