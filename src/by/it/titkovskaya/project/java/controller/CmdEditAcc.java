package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.Payment;
import by.it.titkovskaya.project.java.beans.Replenishment;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditAcc implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        if (Form.isPost(req)) {
            long id = Form.getLong(req, "id");
            long number = Form.getLong(req, "number");
            String currency = Form.getString(req, "currency");
            long users_id = Form.getLong(req, "users_id");
            long account_status_id = Form.getLong(req, "account_status_id");
            Account account = new Account(id, number, currency, users_id, account_status_id);
            if (req.getParameter("update") != null) {
                dao.account.update(account);
            }
        }
        List<Account> accounts = dao.account.getAll();
        req.setAttribute("accounts", accounts);
        List<Replenishment> replenishments = dao.replenishment.getAll();
        req.setAttribute("replenishments", replenishments);
        List<Payment> payments = dao.payment.getAll();
        req.setAttribute("payments", payments);
        return Action.EDITACC;
    }
}
