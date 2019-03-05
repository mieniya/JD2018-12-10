package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.Payment;
import by.it.titkovskaya.project.java.beans.Replenishment;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

public class CmdAccInfo implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            String where = String.format(" WHERE `users_id`='%d'", user.getId());
            Dao dao = Dao.getDao();
            List<Account> accounts = dao.account.getAll(where);
            req.setAttribute("accounts", accounts);

            if (Form.isGet(req) && req.getParameter("accInfoButton")!=null) {
                long id = Form.getLong(req, "id");
                Account account = dao.account.read(id);
                String whereAccId = String.format(" WHERE `accounts_id`='%d'", account.getId());

                List<Replenishment> replenishments = dao.replenishment.getAll(whereAccId);
                req.setAttribute("replenishments", replenishments);

                List<Payment> payments = dao.payment.getAll(whereAccId);
                req.setAttribute("payments", payments);

                String messageInfo = "ACCOUNT № " +account.getNumber() + " STATEMENT";
                req.setAttribute("messageInfo", messageInfo);
                String replenInfo = "Replenishments";
                req.setAttribute("replenInfo", replenInfo);
                String paymentInfo = "Payments / Money transfers";
                req.setAttribute("paymentInfo", paymentInfo);
            }

            return Action.ACCINFO;
        }
        return Action.LOGIN;
    }
}
