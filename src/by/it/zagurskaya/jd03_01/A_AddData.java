package by.it.zagurskaya.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {

    public void addData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `zagurskaya`.`duties` (`idDuties`, `numberUser`, `dateDuties`, `numberDuties`, `isClose`) VALUES (DEFAULT, (SELECT idUser FROM `zagurskaya`.`users` WHERE login='Sidorova'), '2018-02-01', 1, 0);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (643, 0, 0, 0, 0, 0, (SELECT idUser FROM `zagurskaya`.`users` WHERE login='Sidorova'), '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (840, 0, 0, 0, 0, 0, (SELECT idUser FROM `zagurskaya`.`users` WHERE login='Sidorova'), '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (978, 0, 0, 0, 0, 0, (SELECT idUser FROM `zagurskaya`.`users` WHERE login='Sidorova'), '2018-02-01', 1);");
            statement.executeUpdate("INSERT INTO `zagurskaya`.`kassa` (`idCurrency`, `receivedCurrency`, `comingCurrency`, `spendingCurrency`, `hendedCurrency`, `balanceCarrency`, `numberUser`, `date`, `duties`) VALUES (933, 0, 0, 0, 0, 0, (SELECT idUser FROM `zagurskaya`.`users` WHERE login='Sidorova'), '2018-02-01', 1);");
        }
    }
}
