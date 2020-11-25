package persistences;

import java.sql.Connection;

public interface IGenericDAO {
    public Connection getConnection() throws ClassNotFoundException;
}
