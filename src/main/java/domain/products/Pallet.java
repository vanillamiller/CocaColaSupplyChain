package domain.products;

import java.util.Currency;

public class Pallet extends Product {

    private Currency price;

    public Pallet(Flavor flav){
       super(flav);
    }

    public Currency getPrice() {
        return price;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }
}
