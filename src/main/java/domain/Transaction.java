package domain;
import java.util.*;

public class Transaction {


    private int numPallets;
    private Date date;
    private String from;
    private String to;

    public Transaction(int numPallets, Date date, String from, String to) {

        this.numPallets = numPallets;
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public int getNumPallets() {
        return numPallets;
    }

    public Date getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
