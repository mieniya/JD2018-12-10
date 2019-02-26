package by.it.titkovskaya.project.java;

import by.it.titkovskaya.project.beans.Account;
import by.it.titkovskaya.project.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdOpenAcc implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            Account account = new Account();
            account.setUsers_id(3);
            account.setAccount_status_id(2);
            if (Dao.getDao().account.create(account))
                return Action.INDEX;
        }
        return Action.OPENACC;
    }
}
