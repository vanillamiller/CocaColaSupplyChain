package domain;

public interface SupplyChainEntity extends Sends, Receives {
    public Inventory getInventory();
}
