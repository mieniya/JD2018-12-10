package by.it.migunko.jd03_01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class A_AddData {
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

            statement.executeUpdate("INSERT INTO `migunko`.`tours` (`ID`, `Description`, `TypeOfTravel`, `Destination`, `Hotel`, `CountOfNights`, `Price`, `users_ID`) VALUES (DEFAULT, 'пляжный отдых на берегу Красного моря', 'beach holiday', 'Хургада', 'Cordoba Suits', 7, 900.0, 3);");
            statement.executeUpdate("INSERT INTO `migunko`.`tours` (`ID`, `Description`, `TypeOfTravel`, `Destination`, `Hotel`, `CountOfNights`, `Price`, `users_ID`) VALUES (DEFAULT, 'новогодний тур с эксурсиями и шопингом', 'holiday', 'Рига', 'Metropole Hotel by Semarah', 5, 500.0, 3);");
            statement.executeUpdate("INSERT INTO `migunko`.`tours` (`ID`, `Description`, `TypeOfTravel`, `Destination`, `Hotel`, `CountOfNights`, `Price`, `users_ID`) VALUES (DEFAULT, 'тур в Мадрид на выходные', 'excursion', 'Мадрид', 'Cataloniya Ataha', 2, 700.0, 3);");

            if (connection.isClosed()) System.out.println("Соединение с базой прервано");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
