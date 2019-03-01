package by.it.lyakhova.jd03_01;

import by.it.lyakhova.jd03_01.SqlRequest.DropTables;

import java.sql.SQLException;

class C_reset implements DropTables {
    private static Connect connect = new Connect();

    static void deleteSchema(){
        try {
            connect.getStatement().executeUpdate(DROP_SCHEMA);
        }catch (SQLException e){
            System.out.println("Can't delete schema");
        }
    }

    static void deleteTables(){

        try {
            connect.getStatement().executeUpdate(DELETE_TOURS_USERS);
            System.out.println("Delete tours - users");
            connect.getStatement().executeUpdate(DELETE_USERS);
            System.out.println("Delete users");
            connect.getStatement().executeUpdate(DELETE_ROLES);
            System.out.println("Delete roles");
            connect.getStatement().executeUpdate(DELETE_TOURS);
            System.out.println("Delete tours");
            connect.getStatement().executeUpdate(DELETE_PLACE);
            System.out.println("Delete place");
            connect.getStatement().executeUpdate(DELETE_TRANSPORT);
            System.out.println("Delete transport");
            connect.getStatement().executeUpdate(DELETE_HOUSING);
            System.out.println("Delete housing");



        } catch (SQLException e) {
            System.out.println("Can't delete tables");
        }
    }
}
