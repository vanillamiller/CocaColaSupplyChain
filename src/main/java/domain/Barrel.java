package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Barrel extends RawProduct {

    public Barrel(UUID pid, Flavor flav){
        super(pid, flav);
    }

    public List<Product> transform(){
        return new ArrayList<Product>(Collections.nCopies(100, new Pallet(this.getFlavor())));
    }

}
