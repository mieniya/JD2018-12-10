package by.it.titkovskaya.jd03_02.crud;

import by.it.titkovskaya.jd03_02.beans.*;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner_Reset_Init {

    public static void main(String[] args) throws SQLException {

        C_Reset reset = new C_Reset();
        reset.reset();

        C_Init_Tables init = new C_Init_Tables();
        init.init();

        RoleCRUD roleCRUD = new RoleCRUD();
        Role role1 = new Role(0, "administrator");
        Role role2 = new Role(0, "client");
        Role role3 = new Role(0, "guest");
        roleCRUD.create(role1);
        roleCRUD.create(role2);
        roleCRUD.create(role3);
        System.out.println("Created successfully:\n"+role1 +"\n" +role2 +"\n" + role3 +"\n");

        AccountStatusCRUD statusCRUD = new AccountStatusCRUD();
        AccountStatus status1 = new AccountStatus(0, "active");
        AccountStatus status2 = new AccountStatus(0, "locked");
        statusCRUD.create(status1);
        statusCRUD.create(status2);
        System.out.println("Created successfully:\n"+status1 +"\n" +status2 +"\n");

        UserCRUD userCRUD = new UserCRUD();
        User user1 = new User(0, "admin", "00000", "admin@it.by", "Samanta Jones", 1);
        User user2 = new User(0, "johnSMITH", "11111", "johnSMITH@it.by", "John Smith", 2);
        User user3 = new User(0, "janeDOUGH", "22222", "janeDOUGH@it.by", "Jane Dough", 2);
        userCRUD.create(user1);
        userCRUD.create(user2);
        userCRUD.create(user3);
        System.out.println("Created successfully:\n"+user1 +"\n" +user2 +"\n" + user3 +"\n");

        AccountCRUD accountCRUD = new AccountCRUD();
        Account account1 = new Account(0, 111111111, "USD", 2, 2);
        Account account2 = new Account(0, 222222222, "BYN", 2, 1);
        Account account3 = new Account(0, 333333333, "EUR", 3, 1);
        accountCRUD.create(account1);
        accountCRUD.create(account2);
        accountCRUD.create(account3);
        System.out.println("Created successfully:\n"+account1 +"\n" +account2 +"\n" + account3 +"\n");

        PaymentCRUD paymentCRUD = new PaymentCRUD();
        Timestamp payDate1 = new Timestamp(1550564702447L);
        Timestamp payDate2 = new Timestamp(1550564727845L);
        Timestamp payDate3 = new Timestamp(1550564752112L);
        Payment payment1 = new Payment(0,payDate1, 2000, "llc rosting", 1);
        Payment payment2 = new Payment(0, payDate2, 10000, "ue metrostroy", 2);
        Payment payment3 = new Payment(0, payDate3, 25000, "corporation GNB", 3);
        paymentCRUD.create(payment1);
        paymentCRUD.create(payment2);
        paymentCRUD.create(payment3);
        System.out.println("Created successfully:\n"+payment1 +"\n" +payment2 +"\n" + payment3 +"\n");

        ReplenishmentCRUD replenishmentCRUD = new ReplenishmentCRUD();
        Timestamp date1 = new Timestamp(1550564169698L);
        Timestamp date2 = new Timestamp(1550564628100L);
        Timestamp date3 = new Timestamp(1550564662529L);
        Replenishment replenishment1 = new Replenishment(0, date1, 2000, 1);
        Replenishment replenishment2 = new Replenishment(0, date2, 30000, 2);
        Replenishment replenishment3 = new Replenishment(0, date3, 50000, 3);
        replenishmentCRUD.create(replenishment1);
        replenishmentCRUD.create(replenishment2);
        replenishmentCRUD.create(replenishment3);
        System.out.println("Created successfully:\n"+replenishment1 +"\n" +replenishment2 +"\n" + replenishment3 +"\n");
    }
}
