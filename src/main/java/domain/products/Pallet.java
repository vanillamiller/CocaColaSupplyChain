package domain.products;

import mappers.UnitOfWork;

import java.util.Currency;

public class Pallet extends Product {

    private Currency price;

    public Pallet(int pid, Flavor flav){
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
