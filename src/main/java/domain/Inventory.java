package domain;

import domain.Product;

import java.util.List;

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
