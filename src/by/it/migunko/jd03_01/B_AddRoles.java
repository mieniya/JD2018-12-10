package by.it.migunko.jd03_01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class B_AddRoles {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/"+
                                     "?useUnicode=true&characterEncoding=UTF-8",
                             "root",
                             "");
             Statement statement = connection.createStatement()){

            statement.executeUpdate("INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
            statement.executeUpdate("INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Agent');");
            statement.executeUpdate("INSERT INTO `migunko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Buyer');");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
