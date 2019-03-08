package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public class CmdEditAcc implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        User user = Util.findUser(req);
        if (user == null)
            return Action.LOGIN;
        if (user.getRoles_id() != 1)
            return Action.PROFILE;
        if (Form.isPost(req)) {
            long id = Form.getLong(req, "id");
            Account account = dao.account.read(id);
            req.setAttribute("account", account);
            if (req.getParameter("update") != null) {
                long account_status_id = Form.getLong(req, "account_status_id");
                account.setAccount_status_id(account_status_id);
                if (account_status_id == 1) {
                    account.setUnlock_request(0);
                }
                if (dao.account.update(account)) {
                    String message = "NOTIFICATION: Operation completed successfully. Account № "
                            + account.getNumber() + " status is updated.";
                    req.setAttribute("message", message);
                } else {
                    String message = "NOTIFICATION: Operation failed.";
                    req.setAttribute("message", message);
                }
            }
        }
        List<Account> accounts = dao.account.getAll();
        req.setAttribute("accounts", accounts);
        HashMap<Long, Double> balances = AccBalance.getAccBalances(accounts);
        req.setAttribute("balances", balances);
        return Action.EDITACC;
    }

}
