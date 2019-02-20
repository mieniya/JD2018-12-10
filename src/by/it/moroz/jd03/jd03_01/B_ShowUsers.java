package by.it.moroz.jd03.jd03_01;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class B_ShowUsers {
    
    private Map<Integer, String> roles;
    
    B_ShowUsers(){
        this.roles = new HashMap<>();
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void showUsers(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/moroz" +
                "?useUnicode=true&characterEncoding=UTF-8", "root", "");
             Statement statement = connection.createStatement()) {
            ResultSet role = statement.executeQuery("SELECT * FROM `roles`");
            while (role.next()){
                roles.put(role.getInt("id"), role.getString("role"));
            }
            ResultSet user = statement.executeQuery("SELECT * FROM `users`");
            while (user.next()){
                System.out.println( roles.get(user.getInt("roles_id")) + ": " +
                        user.getString("login")+", "+user.getString("password")+", "
                        +user.getString("email")+", "+user.getString("address")+", "
                +user.getString("name")+", "+user.getString("surname")+", "+
                        user.getInt("numberphone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
