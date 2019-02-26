package by.it.lyakhova.jd03_01;


import by.it.lyakhova.jd03_01.SqlRequest.AddData;
import by.it.lyakhova.jd03_01.SqlRequest.CreateTables;

import java.sql.SQLException;

class C_init implements AddData, CreateTables {
    private static Connect connect = new Connect();


    static void addSchema(){

        try {
            connect.getStatement().executeUpdate(CREATE_SCHEMA);
        } catch (SQLException e) {
            System.out.println("Can't create schema");
        }
    }

    static void addTables(){

        try {
            connect.getStatement().executeUpdate(CREATE_ROLES);
            System.out.println("create Roles");
            connect.getStatement().executeUpdate(CREATE_USERS);
            System.out.println("create Users");
            connect.getStatement().executeUpdate(CREATE_PLACE);
            System.out.println("create Place");
            connect.getStatement().executeUpdate(CREATE_TRANSPORT);
            System.out.println("create Transport");
            connect.getStatement().executeUpdate(CREATE_HOUSING);
            System.out.println("create Housing");
            connect.getStatement().executeUpdate(CREATE_TOURS);
            System.out.println("create Toyrs");
            connect.getStatement().executeUpdate(CREATE_TOURS_USERS);
            System.out.println("create tours-users");

        } catch (SQLException e) {
            System.out.println("Can't create tables");
        }
    }

    static void addData(){
        try {
            connect.getStatement().executeUpdate(ADD_ROLES_1);
            connect.getStatement().executeUpdate(ADD_ROLES_2);
            connect.getStatement().executeUpdate(ADD_ROLES_3);
            connect.getStatement().executeUpdate(ADD_ROLES_4);

            connect.getStatement().executeUpdate(ADD_USERS_1);
            connect.getStatement().executeUpdate(ADD_USERS_2);
            connect.getStatement().executeUpdate(ADD_USERS_3);

            connect.getStatement().executeUpdate(ADD_PLACE_1);
            connect.getStatement().executeUpdate(ADD_PLACE_2);
            connect.getStatement().executeUpdate(ADD_PLACE_3);
            connect.getStatement().executeUpdate(ADD_PLACE_4);
            connect.getStatement().executeUpdate(ADD_PLACE_5);
            connect.getStatement().executeUpdate(ADD_PLACE_6);

            connect.getStatement().executeUpdate(ADD_TRANSPORT_1);
            connect.getStatement().executeUpdate(ADD_TRANSPORT_2);
            connect.getStatement().executeUpdate(ADD_TRANSPORT_3);
            connect.getStatement().executeUpdate(ADD_TRANSPORT_4);
            connect.getStatement().executeUpdate(ADD_TRANSPORT_5);
            connect.getStatement().executeUpdate(ADD_TRANSPORT_6);

            connect.getStatement().executeUpdate(ADD_HOUSING_1);
            connect.getStatement().executeUpdate(ADD_HOUSING_2);
            connect.getStatement().executeUpdate(ADD_HOUSING_3);
            connect.getStatement().executeUpdate(ADD_HOUSING_4);

            connect.getStatement().executeUpdate(ADD_TOURS_1);
            connect.getStatement().executeUpdate(ADD_TOURS_2);
            connect.getStatement().executeUpdate(ADD_TOURS_3);

            connect.getStatement().executeUpdate(ADD_TOURS_USERS_1);
            connect.getStatement().executeUpdate(ADD_TOURS_USERS_2);
            connect.getStatement().executeUpdate(ADD_TOURS_USERS_3);


        } catch (SQLException e) {
            System.out.println("Can't add data to tables");
        }
    }

}
