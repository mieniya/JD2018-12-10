package by.it.dziomin.jd03_01;

import java.sql.SQLException;

import static by.it.dziomin.jd03_01.SQL_queries.AddData.ADD_CARS;
import static by.it.dziomin.jd03_01.SQL_queries.AddData.ADD_RENTS;

class A_AddData {
    static void addData() {
        try {
            for (String addCar : ADD_CARS) {
                DBConnector.getStatement().executeUpdate(addCar);
            }

            System.out.println("cars added");
            for (String addRent : ADD_RENTS) {
                DBConnector.getStatement().executeUpdate(addRent);
            }
            System.out.println("rents added");
        } catch (SQLException e) {
            System.out.println("Ошибка заполнения таблиц данными");
        }
    }
}
