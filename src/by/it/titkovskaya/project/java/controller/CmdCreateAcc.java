package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdOpenAcc implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            Account account = new Account();
            account.setNumber(100000004);
            account.setCurrency(Form.getString(req, "currency"));
            account.setUsers_id(3);
            account.setAccount_status_id(1);
            //todo userid
            //todo account number
            if (Dao.getDao().account.create(account))
                return Action.INDEX;
        }
        return Action.OPENACC;
    }
}
