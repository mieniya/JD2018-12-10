package by.it.zagurskaya.jd03_03;

import by.it.zagurskaya.jd03_03.init.C_Reset;
import by.it.zagurskaya.jd03_03.init.C_CreateTable;
import by.it.zagurskaya.jd03_03.init.C_InsertData;

import java.sql.Connection;
import java.sql.SQLException;

public class InitDataBase {
    public static void main(String[] args) {
        try (Connection connection = ConnCreator.getConnection()) {
            new C_Reset().reset(connection);
            new C_CreateTable().readСommands(connection);
            new C_InsertData().readСommands(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
