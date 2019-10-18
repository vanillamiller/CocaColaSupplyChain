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

    public int num_vanilla(){
        int count=0;
        if(products!=null) {
            for (Product p : products) {
                if (p.equals(new Pallet(Flavor.VANILLA, AppSession.getUser().getID()))) {
                    count++;
                }
            }
        }
        return count;
    }

    public int num_regular(){
        int count=0;
        if(products!=null) {
            System.out.println("here are the products in products: " + products);
            for (Product p : products) {
                if (p.equals(new Pallet(Flavor.REGULAR, AppSession.getUser().getID()))) {
                    count++;
                }
            }
        }
        return count;
    }

    public int num_zero(){
        int count=0;
        if(products!=null) {
            for (Product p : products) {
                if (p.equals(new Pallet(Flavor.REGULAR, AppSession.getUser().getID()))) {
                    count++;
                }
            }
        }
        return count;
    }
    public List<Product> get(){
        return products;
    }


}
