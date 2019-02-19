package by.it.dziomin.jd03_01;

public class Runner {
    public static void main(String[] args) {
        new DBConnector();
        C_Reset.dropTables();
        C_Init.init();
        B_AddRoles.addRoles();
        A_AddUser.addUsers();
        A_AddData.addData();
        System.out.println("---------------------------------");
        B_ShowUsers.showData();
    }
}
