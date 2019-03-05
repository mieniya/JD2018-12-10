package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdAccTrans implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            String where = String.format(" WHERE `users_id`='%d'", user.getId());
            Dao dao = Dao.getDao();
            List<Account> accounts = dao.account.getAll(where);
            req.setAttribute("accounts", accounts);
            if (Form.isPost(req)){
                long id = Form.getLong(req, "id");
                Account account = dao.account.read(id);
                HttpSession reqSession = req.getSession();
                reqSession.setAttribute("account", account);
                if (req.getParameter("replenish") != null){
                    return Action.REPLENISH;
                } else if (req.getParameter("payment") != null){
                    return Action.PAYMENT;
                }
                //TODO "Убедиться, что счет назаблокирован перед выполнением транзакций"

            }
            return Action.ACCTRANS;
        }
        return Action.LOGIN;
    }
}
