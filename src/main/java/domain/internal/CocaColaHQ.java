package domain.internal;

import domain.Transaction;
import domain.Transactor;
import mappers.DCMapper;
import mappers.TransactionMapper;

import java.util.ArrayList;
import java.util.List;

public class CocaColaHQ extends Transactor {

    DCMapper dcmap;

    public CocaColaHQ(int id, String name){
        super(id, name);
        this.dcmap=new DCMapper();
    };

    public List<Transaction> getTransactions(){
        List<Transaction> ts=new ArrayList<Transaction>();
        for(DC dc : this.getDistList()) {
            ts.addAll(TransactionMapper.findAll(dc.getID(),"DC"));
        }

        return ts;
    }

    public Transaction getTransactionByID(){
        return new Transaction();
    }

    public List<DC> getDistList(){
            return this.dcmap.findAll();
    }



}
