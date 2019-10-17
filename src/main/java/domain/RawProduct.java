package domain;

import java.util.List;
import java.util.UUID;

public abstract class RawProduct extends Product {

    public RawProduct(UUID pid, Flavor flav) {
        super(pid, flav);
    }
    public RawProduct(Flavor flav){ super(flav); }
    public abstract List<Product> transform();

}
