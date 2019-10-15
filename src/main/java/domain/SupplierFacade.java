package domain;

public class SupplierFacade {

    String name;
    int id;
    Inventory inv;

    public SupplierFacade(int id){
        this.id=id;
        this.inv=;
    }

    public boolean canShip(Order order){
        return inv.get().containsAll(order.list());
    }

    public boolean processOrder(Order order, int from){
        InternalTransactor supplier=(InternalTransactor) TransactorMapper.find(from);
        return supplier.ship(order);
    }

    public


}
