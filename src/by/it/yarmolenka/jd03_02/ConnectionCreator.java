package by.it.yarmolenka.jd03_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionCreator {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    private ConnectionCreator() {
    }

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            synchronized (ConnectionCreator.class){
                if (connection == null || connection.isClosed()){
                    connection = DriverManager.getConnection(CN.URL_DB_ROOT, CN.USER_DB, CN.PASSWORD_DB);
                }
            }
        }
        return connection;
    }
}
