package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.Payment;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CmdPayment implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        Account account = Util.findAccount(req);
        if (user != null & account != null) {
            Dao dao = Dao.getDao();
            req.setAttribute("account", account);
            if (Form.isPost(req)) {
                Payment payment = new Payment();
                Timestamp date = Timestamp.valueOf(LocalDateTime.now());
                payment.setDate(date);
                payment.setAmount(Form.getDouble(req, "amount"));
                payment.setRecipient(Form.getString(req, "recipient"));
                payment.setAccounts_id(account.getId());
                if (dao.payment.create(payment)) {
                    String message = "NOTIFICATION: Operation completed successfully. From account № "
                            + account.getNumber() + " was transferred " + payment.getAmount()
                            + " " + account.getCurrency() + ".";
                    req.setAttribute("message", message);
                } else {
                    String message = "NOTIFICATION: Operation failed. Please, check the correctness of " +
                            "the entered data.";
                    req.setAttribute("message", message);
                }
                //TODO Balance
                //TODO check funds sufficiency !!!
            }
            return Action.PAYMENT;
        }
        return Action.LOGIN;
    }
}
