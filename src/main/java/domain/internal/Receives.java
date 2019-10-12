package domain.internal;

import java.sql.SQLException;

public interface Receives {

    public boolean reStock(int numItems, int fromID) throws SQLException;

}
