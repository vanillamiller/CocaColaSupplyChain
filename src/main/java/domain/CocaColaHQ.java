package domain;

import auth.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CocaColaHQ extends Transactor {

    List<DC> distList= new ArrayList<DC>();

    public CocaColaHQ(int id, String name){
        super(id, name);
        this.distList=DCMapper.findAllDCs();
    };

    public List<Transaction> getTransactions(){
        List<Transaction> ts=new ArrayList<Transaction>();
        for(DC dc : distList) {
            ts.addAll(TransactionMapper.findAllTransactions(dc.getDCID(),"DC"));
        }
        return ts;
    }

    public Transaction getTransactionByID(){
        return new Transaction();
    }
}
