package domain.internal;

import domain.Transaction;
import domain.Transactor;

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

    public boolean restock(int numProducts, int fromID){
        return false;
    }
}
