package domain;

import java.util.ArrayList;
import java.util.List;

public class CocaColaHQ extends Transactor {



    public CocaColaHQ(int id, String name){
        super(id, name);
    };

    public List<Transaction> getTransactions(){
        List<Transaction> ts=new ArrayList<Transaction>();
        for(Transactor t : this.getDistList()) {
            ts.addAll(TransactionMapper.findAll(t.getID()));
        }

        return ts;
    }

    public Transaction getTransactionByID(){
        return new Transaction();
    }

    public List<Transactor> getDistList(){
            return TransactorMapper.findall("hello");
    }

}
