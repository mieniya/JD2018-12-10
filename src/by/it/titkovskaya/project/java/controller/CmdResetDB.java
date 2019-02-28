package by.it.titkovskaya.project.java;

import by.it.titkovskaya.project.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB implements Cmd{

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao.getDao().reset();
        return Action.INDEX;
    }
}
