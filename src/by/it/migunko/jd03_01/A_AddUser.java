package by.it.migunko.jd03_01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class A_AddUser {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `migunko`.`users`(`ID`, `Login`, `Password`, `Email`, `roles_id`) VALUES (DEFAULT,'olga','53534sfd','olya@tut.by',2)");
            statement.executeUpdate("INSERT INTO `migunko`.`users`(`ID`, `Login`, `Password`, `Email`, `roles_id`) VALUES (DEFAULT,'kseniya','skfjkl4n','kseniya@gmail.com',3)");
            statement.executeUpdate("INSERT INTO `migunko`.`users`(`ID`, `Login`, `Password`, `Email`, `roles_id`) VALUES (DEFAULT,'mariya','k4jdk4','maria@tut.by',3)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
