package domain;

import java.util.Date;
import java.util.*;

public class BusinessTransaction extends Transaction {

    private Currency price;

    public BusinessTransaction(int numPallets, Date date, String from, String to, Currency price) {
        super(numPallets, date, from, to);
        this.price = price;
    }

    public Currency getPrice(){
        return this.price;
    }
}
