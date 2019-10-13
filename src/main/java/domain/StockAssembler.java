package domain;

import com.google.gson.Gson;
import domain.internal.Inventory;
import domain.products.StockDTO;

public class StockAssembler {

    public static StockDTO deserialize(Inventory inv){
        int nvan=inv.numVanilla(), nzero=inv.numZero(), nreg=inv.numRegular();
        double pvan=0.0, preg=0.0, pzero=0.0;
        return new StockDTO(nvan, nreg, nzero, pvan, preg, pzero);
    }

    public static String serialize(Inventory  inv){
        Gson gson=new Gson();
        return gson.toJson(inv);
    }

}
