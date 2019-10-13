package domain.internal;

import domain.Transaction;
import domain.Transactor;
import domain.products.Barrel;
import domain.products.Pallet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bottler extends Transactor implements SupplyChainEntity {

    public Bottler(int id, String name){
        super(id, name);
    }
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

//    private List<Pallet> doWork(Barrel b){
//        b.transform();
//    }
}
