package domain;

import domain.SupplyChainEntity;
import domain.Transaction;
import domain.Transactor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Factory extends Transactor implements SupplyChainEntity {

    public Factory(){}
    @Override
    public List<Transaction> getTransactions() {
        return new ArrayList<Transaction>();
    }


    public boolean ship(int shipPallets, int toID) throws SQLException {

        return false;
    }
}