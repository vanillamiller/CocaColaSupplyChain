package domain;

import java.util.Date;

public class Pallet {


    private int palletID;
    private Date date;
    private String flavour;

    public Pallet(int palletID, Date date, String flavour) {

        this.palletID = palletID;
        this.date = date;
        this.flavour = flavour;

    }

    public int getPalletID() {
        return palletID;
    }

    public Date getDate() {
        return date;
    }

    public String getFlavour() {
        return flavour;
    }

}
