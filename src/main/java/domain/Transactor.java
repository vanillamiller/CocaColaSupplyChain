package domain;

import java.util.*;

public abstract class Transactor {

    private int id;
    private String name;
    private List<Transaction> transactions;

    public abstract void Transactor(int id, String name);

    public abstract int getID();

    public abstract String getName();

    public abstract List<Transaction> getTransactions();

    public abstract Transaction getTransactionByID();

}
