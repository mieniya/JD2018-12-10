package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdCreateAcc implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user == null)
            return Action.LOGIN;
        if (Form.isPost(req)) {
            Account account = new Account();
            List<Account> accounts = Dao.getDao().account.getAll();
            account.setNumber(accounts.size() + 100000001);
            account.setCurrency(Form.getString(req, "currency"));
            account.setUsers_id(user.getId());
            account.setAccount_status_id(1);
            Dao dao = Dao.getDao();
            if (dao.account.create(account)) {
//                account.setNumber(account.getId()+100000000);
  //              dao.account.update(account);
                return Action.PROFILE;
            }
        }
        return Action.CREATEACC;
    }
}
