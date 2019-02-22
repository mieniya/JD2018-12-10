package by.it.lyakhova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {


    private Statement statement;

    public Statement getStatement() {
        return statement;
    }


    static { //при вызове класса этот блок сразу же отработает
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    Connect() {
        try {
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/",
                            "root", "123456789");
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        new Connect();
        System.out.println("open");
    }*/

}

