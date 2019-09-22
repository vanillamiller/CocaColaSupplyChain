package domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TransactionMapper {
    public static List<Transaction> transactions;
    public static List<Transaction> getAllTransactions(){
        if (transactions == null) {
            transactions = new LinkedList<Transaction>();
            Date date = new Date();
            transactions.add(new Transaction(1,date,1,1));
            transactions.add(new Transaction(1,date,2,2));
            transactions.add(new Transaction(1,date,3,3));
        }
        return transactions;
    }

    public static void addtran(Transaction tran){
        if (transactions == null) {
            transactions = new LinkedList<Transaction>();
            transactions.add(tran);
        }
        else{
            transactions.add(tran);
        }
    }

    public static Transaction makeTransaction(int numPallets, int fromID, int toID) {
        //        TODO when makeTransaction is called, need to auto increment transaction ID.
        Date date = new Date();
        Transaction tran = new Transaction(numPallets,date,fromID,toID);
//        transactions.add(tran);
        addtran(tran);
        return null;
    }
}