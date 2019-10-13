package domain.internal;

import domain.products.Barrel;
import domain.products.Flavor;
import domain.products.Order;
import domain.products.Product;

import java.util.List;
import java.util.Map;

public class Inventory {

    private List<Product> products;

    public void add(Product p){
        this.products.add(p);
    }

    public void remove(Product p){
        this.products.remove(p);
    }

    public List<Product> get(){
        return products;
    }


}
