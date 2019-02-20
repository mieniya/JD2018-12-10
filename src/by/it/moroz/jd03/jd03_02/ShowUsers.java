package by.it.moroz.jd03.jd03_02;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ShowUsers {

    private Map<Integer, String> roles;

    ShowUsers(){
        this.roles = new HashMap<>();
    }

    void showUsers(){
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int countUsers=0;
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
                        user.getInt("phonenumber"));
                countUsers++;
            }
            System.out.println("Total users: "+countUsers+"\nTotal roles: "+roles.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
