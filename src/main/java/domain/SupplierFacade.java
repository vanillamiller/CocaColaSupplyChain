package domain;

import domain.internal.Inventory;
import domain.products.Order;
import domain.products.StockDTO;
import mappers.ProductMapper;
import mappers.UnitOfWork;

import java.util.Currency;

public class SupplierFacade {

    String name;
    Inventory inv;

    public SupplierFacade(int id){

        ProductMapper pm=new ProductMapper();
        this.inv=pm.findall(id);
    }



    public boolean processOrder(Order order){

        if (this.canShip(order)){
            UnitOfWork.newCurrent();
        } else { return false; }

    }

    public StockDTO stockDTO (Inventory inv){
        double price=0.00;
        return new StockDTO("name", inv.numVanilla(), inv.numRegular(), inv.numZero(),price,price,price);
    }

}
