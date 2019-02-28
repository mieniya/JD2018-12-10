package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdAccManage implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            String where = String.format(" WHERE `users_id`='%d'", user.getId());
            Dao dao = Dao.getDao();
            List<Account> accounts = dao.account.getAll(where);
            req.setAttribute("accounts", accounts);

            if (Form.isPost(req)) {
                String operation = Form.getString(req, "operation");
                if (operation.equalsIgnoreCase("Replenish"))
                    return Action.REPLENISH;
                if (operation.equalsIgnoreCase("Payment"))
                    return Action.PAYMENT;
                if (operation.equalsIgnoreCase("AccLock"))
                    return Action.ACCLOCK;
            }
            return Action.ACCMANAGE;
        }
        return Action.LOGIN;
    }
}
