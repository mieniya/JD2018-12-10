package by.it.yarmolenka.jd03_01;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class B_ShowGamblers {
    private Map<Integer, String> role;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    B_ShowGamblers() {
        this.role = new HashMap<>();
    }

    void showGamblers() {
        try (Connection connection = DriverManager.getConnection(CN.URL_DB_ROOT, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSetRoles = statement.executeQuery("select * from roles");
            while (resultSetRoles.next())
                role.put(resultSetRoles.getInt("id"), resultSetRoles.getString("role"));
            ResultSet resultSet = statement.executeQuery("select * from gamblers;");
            while (resultSet.next()){
                String out = role.get(resultSet.getInt("fk_roles")) +
                        " - " + resultSet.getString("login");
                System.out.println(out);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
