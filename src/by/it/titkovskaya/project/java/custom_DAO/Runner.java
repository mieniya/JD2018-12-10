package by.it.titkovskaya.project.java.custom_DAO;

import by.it.titkovskaya.project.java.beans.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao = Dao.getDao();

        User user = new User();
        List<User> users = dao.user.getAll();
        if (users.size() > 0)
            System.out.println("\nREAD OK: " + users);
        user.setRoles_id(3);
        if (dao.user.create(user))
            System.out.println("CREATE OK: " + user);
        user.setEmail("test@user");
        if (dao.user.update(user))
            System.out.println("UPDATE OK: " + user);
        if (dao.user.delete(user))
            System.out.println("DELETE OK: " + users);

        Role role = new Role();
        List<Role> roles = dao.role.getAll();
        if (roles.size() > 0)
            System.out.println("\nREAD OK: " + roles);
        if (dao.role.create(role))
            System.out.println("CREATE OK: " + role);
        role.setRole("moderator");
        if (dao.role.update(role))
            System.out.println("UPDATE OK: " + role);
        if (dao.role.delete(role))
            System.out.println("DELETE OK: " + roles);

        Account account = new Account();
        List<Account> accounts = dao.account.getAll();
        if (accounts.size() > 0)
            System.out.println("\nREAD OK: " + accounts);

        String where = " WHERE `number`='100000003'";
        System.out.println("\n*********************************************************");
        System.out.println("\n>>>>>>>>>>>>  <<<<<<<<<<<<" + dao.account.getAll(where));
        String where1 = " WHERE `accounts_id`='3'";
        System.out.println("\n>>>>>>>>>>>>  <<<<<<<<<<<<" + dao.replenishment.getAll(where1));
        System.out.println("\n>>>>>>>>>>>>  <<<<<<<<<<<<" + dao.payment.getAll(where1));

        List<Replenishment> allRep = dao.replenishment.getAll(where1);
        double repSum = 0;
        for (int i = 1; i < allRep.size(); i++) {
            repSum += allRep.get(i).getAmount();
        }
        List<Payment> allPay = dao.payment.getAll(where1);
        double paySum = 0;
        for (int i = 0; i < allRep.size() - 1; i++) {
            paySum += allPay.get(i).getAmount();
        }
        double balance = repSum - paySum;
        System.out.println("TOTAL replenishments: " + repSum);
        System.out.println("TOTAL payments: " + paySum);
        System.out.println("ACCOUNT BALANCE: " + balance);
        System.out.println("\n**********************************************************\n");

        account.setUsers_id(3);
        account.setAccount_status_id(2);
        if (dao.account.create(account)) {
            account.setNumber(account.getId() + 100000000);
            dao.account.update(account);
            System.out.println("***********CREATE OK: " + account);
        }

        account.setNumber(account.getId() + 100000000);
        if (dao.account.update(account))
            System.out.println("*****UPDATE OK: " + account);
        if (dao.account.delete(account))
            System.out.println("DELETE OK: " + accounts);

        Replenishment replenishment = new Replenishment();
        List<Replenishment> replenishments = dao.replenishment.getAll();
        if (replenishments.size() > 0)
            System.out.println("\nREAD OK: " + replenishments);
        replenishment.setAccounts_id(3);
        replenishment.setDate(Timestamp.valueOf("2019-02-21 18:00:00"));
        if (dao.replenishment.create(replenishment))
            System.out.println("CREATE OK: " + replenishment);
        replenishment.setAmount(40000);
        if (dao.replenishment.update(replenishment))
            System.out.println("UPDATE OK: " + replenishment);
        if (dao.replenishment.delete(replenishment))
            System.out.println("DELETE OK: " + replenishments);

        Payment payment = new Payment();
        List<Payment> payments = dao.payment.getAll();
        if (payments.size() > 0)
            System.out.println("\nREAD OK: " + payments);
        payment.setAccounts_id(3);
        com.sun.jmx.snmp.Timestamp timestamp = new com.sun.jmx.snmp.Timestamp();
        Timestamp payDate = new Timestamp(timestamp.getDateTime());
        payment.setDate(payDate);
        if (dao.payment.create(payment))
            System.out.println("CREATE OK: " + payment);
        payment.setAmount(35000);
        if (dao.payment.update(payment))
            System.out.println("UPDATE OK: " + payment);
        if (dao.payment.delete(payment))
            System.out.println("DELETE OK: " + payments);

        AccountStatus status = new AccountStatus();
        List<AccountStatus> statuses = dao.status.getAll();
        if (statuses.size() > 0)
            System.out.println("\nREAD OK: " + statuses);
        if (dao.status.create(status))
            System.out.println("CREATE OK: " + status);
        status.setStatus("TESTstatus");
        if (dao.status.update(status))
            System.out.println("UPDATE OK: " + status);
        if (dao.status.delete(status))
            System.out.println("DELETE OK: " + statuses);

        String login = "login";
        String password = "password";
        String email = "email";
        String name = "name";
        User userT = new User(0, login, password, email, name, 2);
        Dao daoT = Dao.getDao();
        if (daoT.user.create(userT)) {
            System.out.println("TEST of PROJECT +++");
            ;
        }

        String whereAccNumber = " WHERE `number`='100000004'";
        List<Account> accByNumber = dao.account.getAll(whereAccNumber);
        if (accByNumber.size() > 0) {
            String state = "lock";
            Account accounT = accByNumber.get(0);

            //******************* НЕ ПАШЕТ >>> UPDATE <<<
            if (state.equalsIgnoreCase("lock")) {
                accounT.setAccount_status_id(2);
            } else if (state.equalsIgnoreCase("unlock"))
                accounT.setAccount_status_id(1);
            if (dao.account.update(accounT)) {
                System.out.println("STATE: " + accounT);
            }
            System.out.println("STATE2: " + accounT);
            //******************* НЕ ПАШЕТ
        }

        List<Payment> totalPayment = dao.payment.getAll();
        System.out.println(totalPayment);

        List<Account> accountAll = dao.account.getAll();

        String forBalance = "[ ";
        String delimiter = "";

        for (int i = 0; i < accountAll.size(); i++) {
            double replenByAcc = dao.replenishment.getTotalReplenishmentForAccount(accountAll.get(i).getId());
            System.out.println(accountAll.get(i).getNumber() + "=" +replenByAcc);
            double paymentByAcc = dao.payment.getTotalPaymentForAccount(accountAll.get(i).getId());
            System.out.println(accountAll.get(i).getNumber() + "=" +paymentByAcc);
            double balance2 = replenByAcc - paymentByAcc;
            System.out.println("Balance: " + accountAll.get(i).getNumber() + "=" +balance2);

            long id = accountAll.get(i).getId();
            forBalance = forBalance.concat(delimiter).
                    concat(String.format("Balance{accounts_id=%d, balance=%.1f}",id,balance2));
            delimiter=",";

        }
        System.out.println(forBalance.concat("]"));


        //       Dao.getDao().reset();
    }
}

