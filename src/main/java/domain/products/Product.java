package domain.products;

import domain.products.Flavor;
import mappers.UnitOfWork;

public abstract class Product {

    private Flavor flavor;
    private int pid;

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

    public Product(int pid, Flavor flavor){
        this.pid=pid;
        this.flavor=flavor;
    }

    public Flavor getFlavor(){
        return this.flavor;
    }

}
