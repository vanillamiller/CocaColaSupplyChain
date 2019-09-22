package domain;

import java.util.List;

public class Inventory {

    private int inventoryID;
    private List<Pallet> palletInventory;

    public int getNumPallets() {
        return palletInventory.size();
    }

}
