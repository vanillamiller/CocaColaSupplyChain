package domain;

public abstract class InternalTransactor extends Transactor implements SupplyChainEntity{

    public InternalTransactor(int id, String name){
        super(id, name);
    }

    public InternalTransactor(){ super(); }

    @Override
    public Inventory getInventory() {
        return ProductMapper.findall(this.getID());
    }

}
