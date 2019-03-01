package by.it.moroz.jd03.jd03_01;

public class Runner {

    public static void main(String[] args) {
        A_AddData addData = new A_AddData();
        A_AddUser addUser = new A_AddUser();
        A_CreateDB createDB = new A_CreateDB();
        B_AddRoles addRoles = new B_AddRoles();
        B_ShowUsers showUsers = new B_ShowUsers();
        C_Init init = new C_Init();
        C_Reset reset = new C_Reset();

        reset.resetDB();
        createDB.createDB();
        addRoles.addRoles();
        addUser.addUsers();
        addData.addData();
        showUsers.showUsers();
        init.initDB();
    }
}
