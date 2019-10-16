package domain;

import java.util.Currency;
import java.util.UUID;

public class Pallet extends Product {

    private Currency price;

    public Pallet(UUID pid, Flavor flav){
       super(pid, flav);
    }

    public Pallet(Flavor flav){
        super(flav);
        //        UnitOfWork.getCurrent().registerNew(this);
    }

    public Currency getPrice() {
        return price;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }
}