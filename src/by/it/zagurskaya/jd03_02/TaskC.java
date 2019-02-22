package by.it.zagurskaya.jd03_02;

import by.it.zagurskaya.jd03_01.C_Reset;

import java.sql.Connection;
import java.sql.SQLException;

public class TaskC {
    public static void main(String[] args) {
        try (Connection connection = ConnCreator.getConnection()){
            new C_Reset().reset(connection);
            new C_CreateTable().readСommands(connection);
            new C_InsertData().readСommands(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
