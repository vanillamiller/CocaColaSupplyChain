package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CocaColaHQ extends Transactor {

    Factory factory=new Factory();

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

    public static List<Transactor> getAllTransactors(){
        List<Transactor> ts=new ArrayList<Transactor>();
        ts=TransactorMapper.getall();
        return ts;
    }

    public Transaction getTransactionByID(){
        return new Transaction();
    }

    public List<Transactor> getDistList(){
            return TransactorMapper.findall("hello");
    }

    public boolean ship(Order order){
        try {
            factory.produce(order);
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

}
