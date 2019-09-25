package domain;
import java.util.*;

public class Transaction {
    private int txID;
    private int numPallets;
    private Date date;
    private Integer from;
    private Integer to;

    public Transaction(){};

    public Transaction(int numPallets, Date date, Integer from, Integer to) {
        this.numPallets = numPallets;
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public Transaction(int txID, int numPallets, Date date, Integer from, Integer to) {
        this.txID = txID;
        this.numPallets = numPallets;
        this.date = date;
        this.from = from;
        this.to = to;

    }
    public int gettxID() {

        return txID;
    }

    public int getNumPallets() {

        return numPallets;
    }

    public Date getDate() {

        return date;
    }

    public Integer getFrom() {

        return from;
    }

    public Integer getTo() {

        return to;
    }
}
