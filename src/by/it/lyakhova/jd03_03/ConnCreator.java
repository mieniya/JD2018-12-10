package by.it.lyakhova.jd03_03;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnCreator {

    static {
        Driver driver;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        } catch (SQLException e) {
            System.out.println("Error: not register driver: "+e);
        }
    }


    private static volatile Connection connection;

    private ConnCreator(){}

    public static Connection getConnection() throws SQLException {
        if (connection==null || connection.isClosed()){
            synchronized (ConnCreator.class){
                if (connection==null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.URL, CN.USER, CN.PASSWORD);
                }
            }
        }
        return connection;
    }

}

