package domain;

public class SupplierFacade {

    String name;
    int id;
    Inventory inv;

    public SupplierFacade(int id){
        this.id=id;
        this.inv = this.getInventory();
    }

    public boolean canShip(Order order){
        return inv.get().containsAll(order.list());
    }

    public boolean processOrder(Order order, int from){
//        TODO check if canShip here first
        InternalTransactor supplier = (InternalTransactor) TransactorMapper.find(from);
        return supplier.ship(order);
    }

    public Inventory getInventory(){
        return ProductMapper.findall(this.id);
    }


}
