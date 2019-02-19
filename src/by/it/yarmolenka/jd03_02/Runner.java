package by.it.yarmolenka.jd03_02;

import by.it.yarmolenka.jd03_02.beans.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        SportCRUD sportCRUD = new SportCRUD();
        Sport tennis = new Sport(0, "tennis");
        if (sportCRUD.create(tennis)) {
            Sport created = sportCRUD.read(tennis.getId());
            System.out.println("Sport created and read: " + created);
        }
        tennis.setSport("ping_pong");
        if (sportCRUD.update(tennis)) {
            Sport updated = sportCRUD.read(tennis.getId());
            System.out.println("Sport updated and read: " + updated);
        }
        if (sportCRUD.delete(tennis)) System.out.println("Sport deleted: " + tennis);



        MatchStatusCRUD statusCRUD = new MatchStatusCRUD();
        MatchStatus stat = new MatchStatus(0, "processing");
        if (statusCRUD.create(stat)) {
            MatchStatus status = statusCRUD.read(stat.getId());
            System.out.println("Match status created and read: " + status);
        }
        stat.setStatus("finished");
        if (statusCRUD.update(stat)){
            MatchStatus status = statusCRUD.read(stat.getId());
            System.out.println("Match status updated and read: " + status);
        }
        if (statusCRUD.delete(stat)) System.out.println("Match status deleted: " + stat);


        AdminCRUD adminCRUD = new AdminCRUD();
        Admin admin = new Admin(0, "admin_login", "admin_email", "admin_pass");
        if (adminCRUD.create(admin)) {
            Admin admin2 = adminCRUD.read(admin.getId());
            System.out.println("Admin created and read: " + admin2);
        }
        admin.setLogin("admin_updated_login");
        if (adminCRUD.update(admin)) {
            Admin admin2 = adminCRUD.read(admin.getId());
            System.out.println("Admin updated and read: " + admin2);
        }
        if (adminCRUD.delete(admin)) System.out.println("Admin deleted: " + admin);


        GamblerCRUD gamblerCRUD = new GamblerCRUD();
        Gambler gambler = new Gambler(0, "gambler_login", "gambler_email", "gambler_pass");
        if (gamblerCRUD.create(gambler)) {
            Gambler createdGambler = gamblerCRUD.read(gambler.getId());
            System.out.println("Gambler created and read: " + createdGambler);
        }
        gambler.setLogin("gambler_updated_login");
        if (gamblerCRUD.update(gambler)) {
            Gambler updatedGambler = gamblerCRUD.read(gambler.getId());
            System.out.println("Gambler updated and read: " + updatedGambler);
        }
        if (gamblerCRUD.delete(gambler)) System.out.println("Gambler deleted: " + gambler);


        CashierCRUD cashierCRUD = new CashierCRUD();
        Cashier cashier = new Cashier(0, 1000.0, 800.0, 200.0, 1, 1);
        if (cashierCRUD.create(cashier)) {
            Cashier createdCashier = cashierCRUD.read(cashier.getId());
            System.out.println("Cashier created and read: " + createdCashier);
        }
        cashier.setOverall(2222.2);
        if (cashierCRUD.update(cashier)) {
            Cashier updatedCashier = cashierCRUD.read(cashier.getId());
            System.out.println("Cashier updated and read: " + updatedCashier);
        }
        if (cashierCRUD.delete(cashier)) System.out.println("Cashier deleted: " + cashier);
    }
}
