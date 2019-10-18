package domain;

import java.util.*;

public class Transaction implements Created {
    private Date date;
    private Order order;
    private Integer from;
    private Integer to;

    public Transaction(){};

    public Transaction(Order order, Integer from, Integer to) {
        this.order=order;
        this.from=from;
        this.to=to;
        this.create();
    }
    public void create(){
        UnitOfWork.getCurrent().registerNew(this);
    }

    public Order getOrder(){
        return this.order;
    }

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
