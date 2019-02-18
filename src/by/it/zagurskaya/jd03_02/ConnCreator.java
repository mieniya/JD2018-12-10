package by.it.zagurskaya.jd03_02;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnCreator {
    private static volatile Connection connection;
    private ConnCreator() {

    }
    static Connection getConnection () throws SQLException {
        if (connection == null || connection.isClosed()) {
//            synchronized (getConnection());
        }
        return connection;
    }
}
