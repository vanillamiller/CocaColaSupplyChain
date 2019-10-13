package domain.products;

import domain.products.Flavor;
import mappers.ProductMapper;
import mappers.UnitOfWork;

import java.sql.SQLException;
import java.util.UUID;

public abstract class Product {

    private Flavor flavor;
    private UUID pid;

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

    public Product(UUID pid, Flavor flavor){
        this.pid=pid;
        this.flavor=flavor;
    }

    @Override
    public boolean equals(Object other){
        if(! (other instanceof Product))
            return false;
        if(this.getClass().equals(other.getClass())){
            Product temp=(Product) other;
            if(this.flavor==temp.flavor){
                return true;
            }
        }
        return false;
    }

    public void ship(int toID) throws SQLException{
        ProductMapper.update(this.pid, toID);
    }

    public Flavor getFlavor(){
        return this.flavor;
    }

}
