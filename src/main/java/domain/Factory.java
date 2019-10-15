package domain;

import domain.Transaction;
import domain.Transactor;
import domain.Order;

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