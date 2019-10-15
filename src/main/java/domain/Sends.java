package domain;

import domain.Order;

public interface Sends {
    public boolean ship(Order order);
}
