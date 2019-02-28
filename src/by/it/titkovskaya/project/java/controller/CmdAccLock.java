package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdAccLock implements Cmd {

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
                if (accByNumber.size() > 0) {
                    String status = Form.getString(req, "status");
                    Account account = accByNumber.get(0);

                    //******************* НЕ ПАШЕТ >>> UPDATE <<<
                    if (status.equalsIgnoreCase("lock")) {
                        account.setAccount_status_id(2);
                    }
                    else if (status.equalsIgnoreCase("unlock"))
                        account.setAccount_status_id(1);

                    //TODO "Снятие блокировки админом"
                    //TODO "Проверку на принадлежность счета юзеру или выпадающий список ЕГО счетов"

                    if (dao.account.update(account)) {
                        return Action.ACCINFO;
                    }
                    //******************* НЕ ПАШЕТ
                }
            }
            return Action.ACCLOCK;
        }
        return Action.LOGIN;
    }
}
