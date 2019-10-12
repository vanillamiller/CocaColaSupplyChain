package domain.products;

import domain.products.Flavor;

public abstract class Product {

    private Flavor flavor;

    public Product(Flavor flav){
        switch(flav){
            case REGULAR :
                this.flavor=Flavor.REGULAR;
                break;
            case ZERO :
                this.flavor=Flavor.ZERO;
                break;
            case VANILLA :
                this.flavor=Flavor.VANILLA;
                break;
        }
    }

    public Flavor getFlavor(){
        return this.flavor;
    }

}
