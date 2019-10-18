package domain;

import com.google.gson.JsonElement;

import java.rmi.RemoteException;

public class SupplierFacade {

    String name;
    int id;
    Inventory inv;

    public SupplierFacade(int id){
        this.id=id;
        this.inv = this.getInventory();
    }
    public static StockDTO getStock(int id) throws RemoteException {
//        System.out.println("THIS IS THE WEHRE WE ARE UP TO YOLOLOL");
        Inventory inv = ProductMapper.findall(id);
        StockDTO result = new StockDTO();
        result.setNumRegular(inv.num_regular());
        result.setNumVanilla(inv.num_vanilla());
        result.setNumZero(inv.num_zero());
        System.out.println("THIS IS THE RESULT:" + result);
        return result;
    }

    public static JsonElement getStockJson(int id) throws RemoteException {
        StockDTO dto = getStock(id);
        JsonElement dtojson = StockDTO.toJson(dto);
        return dtojson;
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
