package domain;

import mappers.TransactorMapper;

import java.util.*;

public abstract class Transactor {

    private int id;
    private String name;
    private List<Transaction> transactions;

    public Transactor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getID(){
        return this.id;
    };

    public String getName(){
        return this.name;
    };

    public abstract List<Transaction> getTransactions();

}
