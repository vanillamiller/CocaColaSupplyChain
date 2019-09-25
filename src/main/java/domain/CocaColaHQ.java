package domain;

import mappers.DCMapper;
import mappers.TransactionMapper;

import java.util.ArrayList;
import java.util.List;

public class CocaColaHQ extends Transactor {

    List<DC> distList=new ArrayList<DC>();

    public CocaColaHQ(int id, String name){
        super(id, name);
    };

    public List<Transaction> getTransactions(){
        List<Transaction> ts=new ArrayList<Transaction>();

        for(DC dc : this.getDistList()) {
            ts.addAll(TransactionMapper.findAllTransactions(dc.getID(),"DC"));
        }

        return ts;
    }

    public Transaction getTransactionByID(){
        return new Transaction();
    }

    public List<DC> getDistList(){
        if(this.distList.isEmpty()){
            this.distList = DCMapper.findAllDCs();
        }
        return this.distList;
    }

}
