package domain.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Barrel extends RawProduct {

    public Barrel(Flavor flav){
        super(flav);
    }

    public List<Product> transform(){
        return new ArrayList<Product>(Collections.nCopies(100, new Pallet(this.getFlavor())));
    }

}
