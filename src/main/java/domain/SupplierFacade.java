package domain;

import domain.internal.Inventory;
import domain.internal.Sends;
import domain.internal.SupplyChainEntity;
import domain.products.Order;
import domain.products.StockDTO;
import mappers.ProductMapper;
import mappers.TransactorMapper;
import mappers.UnitOfWork;

import java.util.Currency;

public class SupplierFacade {

    String name;
    int id;
    Inventory inv;

    public SupplierFacade(int id){
        this.id=id;
        this.inv=ProductMapper.findall(id);
    }

    public boolean canShip(Order order){
        return inv.get().containsAll(order.list());
    }

    public boolean processOrder(Order order, int from){
        Transactor supplier=TransactorMapper.find(from);
        return supplier.ship(order);
    }


}
