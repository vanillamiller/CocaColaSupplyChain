package domain.products;

import java.util.List;

public abstract class RawProduct extends Product {

    public RawProduct(Flavor flav) {
        super(flav);
    }

    public abstract List<Product> transform();

}
