package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bottler extends InternalTransactor implements SupplyChainEntity {

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

    @Override
    public boolean ship(Order order) {
        return false;
    }
    //    private List<Pallet> doWork(Barrel b){

//    }
}
