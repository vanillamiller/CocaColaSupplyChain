package domain.internal;

import domain.products.Flavor;
import domain.products.Order;
import domain.products.Product;

import java.util.List;

public class Inventory {
    private List<Product> regular;
    private List<Product> zero;
    private List<Product> vanilla;

    public int numVanilla(){
        return vanilla.size();
    }

    public int numRegular(){
        return regular.size();
    }

    public int numZero(){
        return vanilla.size();
    }

    public void add(Order o){

        int i;
        for (i=0;i<o.getNumZero();i++)
            this.zero.add(p);

        if(p.getFlavor()== Flavor.REGULAR){
            this.regular.add(p);
        } else if (p.getFlavor()== Flavor.ZERO){

        } else if  (p.getFlavor()== Flavor.VANILLA){
            this.vanilla.add(p);
        }
    }

    public void remove(Product p){
        if(p.getFlavor()== Flavor.REGULAR){
            this.regular.remove(0);
        } else if (p.getFlavor()== Flavor.ZERO){
            this.zero.remove(0);
        } else if  (p.getFlavor()== Flavor.VANILLA){
            this.vanilla.remove(0);
        }
    }


}
