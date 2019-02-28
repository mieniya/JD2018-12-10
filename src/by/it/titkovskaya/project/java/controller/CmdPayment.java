package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.Payment;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class CmdPayment implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            String where = String.format(" WHERE `users_id`='%d'", user.getId());
            Dao dao = Dao.getDao();
            List<Account> accounts = dao.account.getAll(where);
            req.setAttribute("accounts", accounts);

            if (Form.isPost(req)) {
                String whereAccNumber = String.format(" WHERE `number`='%d'", Form.getInt(req, "accNumber"));
                List<Account> accByNumber = dao.account.getAll(whereAccNumber);
                long accountId = 0;
                if (accByNumber.size() > 0) {
                    accountId = accByNumber.get(0).getId();
                }

                Payment payment = new Payment();
                Timestamp date = Timestamp.valueOf(LocalDateTime.now());
                payment.setDate(date);
                payment.setAmount(Form.getDouble(req, "amount"));
                payment.setRecipient(Form.getString(req, "recipient"));
                payment.setAccounts_id(accountId);

                //TODO Balance check + Account existence & ownership

                if (dao.payment.create(payment)) {
                    return Action.ACCINFO;
                }
            }
            return Action.PAYMENT;
        }
        return Action.LOGIN;
    }
}
