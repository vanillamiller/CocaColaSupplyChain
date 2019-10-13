package domain.internal;

import domain.Transaction;
import domain.Transactor;
import domain.products.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Factory extends Transactor {

    public Factory(){}

    @Override
    public List<Transaction> getTransactions() {
        return new ArrayList<Transaction>();
    }


    public boolean ship(Order order)  {
        return false;
    }

}