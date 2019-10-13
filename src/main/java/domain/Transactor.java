package domain;

import domain.internal.Sends;
import mappers.TransactorMapper;

import java.util.*;

public abstract class Transactor implements Sends {

    private int id;
    private String name;
    private String password;
    private List<Transaction> transactions;

    public Transactor(){};

    public Transactor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object other){
        if(other.getClass().equals(this.getClass())) {
            Transactor oth=(Transactor) other;
            return (this.getID() == oth.getID());
        }
        return false;
    }

    public int getID(){
        return this.id;
    };

    public String getName(){
        return this.name;
    };

    public abstract List<Transaction> getTransactions();

    public String getPassword() {
        return password;
    }
}
