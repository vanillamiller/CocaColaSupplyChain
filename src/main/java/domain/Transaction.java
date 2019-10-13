package domain;
import domain.products.Order;
import mappers.UnitOfWork;

import java.util.*;

public class Transaction {
    private Date date;
    private Order order;
    private Integer from;
    private Integer to;

    public Transaction(){};

    public Transaction(Order order, Integer from, Integer to) {
        this.order=order;
        this.from=from;
        this.to=to;
        UnitOfWork.getCurrent().registerNew(this);
    }

//    public Transaction(int txID, int numPallets, Date date, Integer from, Integer to) {
//        this.date = date;
//        this.from = from;
//        this.to = to;
//    }

    public Date getDate() {

        return date;
    }

    public Integer getFrom() {

        return from;
    }

    public Integer getTo() {

        return to;
    }
}
