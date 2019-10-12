package domain.products;

import domain.internal.Transforms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Barrel extends RawProduct implements Transforms {

    public Barrel(Flavor flav){
        super(flav);
    }

    public List<Product> transform(){
        return new ArrayList<Product>(Collections.nCopies(100, new Pallet(this.getFlavor())));
    }
}
