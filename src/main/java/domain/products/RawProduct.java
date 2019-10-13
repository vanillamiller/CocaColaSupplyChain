package domain.products;

import java.util.List;

public abstract class RawProduct extends Product {

    public RawProduct(int pid, Flavor flav) {
        super(pid, flav);
    }
    public abstract List<Product> transform();

}
