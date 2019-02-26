package by.it.naron.jd03_04.java.controller;


import by.it.naron.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao.getDao().reset();
        return Action.INDEX;
    }
}
