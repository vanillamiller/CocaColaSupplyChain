package domain;

import java.sql.SQLException;

public interface ClientEntity {
    public boolean buy(Order order, int id);
}
