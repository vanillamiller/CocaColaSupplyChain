package domain.internal;

import domain.products.Order;

import java.sql.SQLException;

public interface Sends {
    public boolean ship(Order order);
}
