package domain;

import domain.Transaction;
import domain.Transactor;
import domain.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Factory {

    public Factory(){}

    public void produce(Order order) throws SQLException {
        UnitOfWork.newCurrent();
        for (Product p : order.get()){
            new Barrel(p.getFlavor(),order.getReceiver());
        }
    }

}