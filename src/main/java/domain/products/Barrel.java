package domain.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Barrel extends RawProduct {

    public Barrel(int pid, Flavor flav){
        super(pid, flav);
    }

    public List<Product> transform(){
        return new ArrayList<Product>(Collections.nCopies(100, new Pallet(this.getFlavor())));
    }

}
