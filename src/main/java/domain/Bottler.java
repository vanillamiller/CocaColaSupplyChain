package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bottler extends Transactor implements SupplyChainEntity {

    public Bottler(){}
    @Override
    public List<Transaction> getTransactions() {
        return new ArrayList<Transaction>();
    }


    public boolean ship(int shipPallets, int toID) throws SQLException {

        return false;
    }
}
