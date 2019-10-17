package domain;

import java.rmi.RemoteException;
import java.util.*;
import java.util.function.Supplier;

public abstract class Transactor {

    private int id;
    private String username, password, name;
    private List<Transaction> transactions;

    public Transactor(){};

    public Transactor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Transactor get(int id){
        return TransactorMapper.find(id);
    }

    public static Transactor get(String username){
        Transactor x = TransactorMapper.find(username);
        System.out.println("well here we are in transactorget" + x);
        return x;
    }

    @Override
    public boolean equals(Object other){
        if(other.getClass().equals(this.getClass())) {
            Transactor oth=(Transactor) other;
            return this.getID()==oth.getID();
        }
        return false;
    }

    public List<Transactor> getMyTransactors(){
        return TransactorMapper.findMyTransactors(this.id);
    }

    public int getID(){
        return this.id;
    };

    public String getName(){
        return this.name;
    };

    public String getStock() throws RemoteException {
        System.out.println("HERE IS AM IN TRANSACTOR");
        return SupplierFacade.getStock(this.id);
    }

    public List<Transaction> getTransactions(){
        return TransactionMapper.findAll(this.id);
    }

    public void setPassword(String pass){ this.password=pass; }

    public void setUsername(String username) { this.username=username; }

    public String getPassword() {
        return password;
    }
}
