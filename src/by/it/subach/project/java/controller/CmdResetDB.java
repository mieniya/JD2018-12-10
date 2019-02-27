package by.it.subach.project.java.controller;

import javax.servlet.http.HttpServletRequest;

import static by.it.subach.project.java.dao.DAO.getInstance;

public class CmdResetDB implements Cmd {


    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        getInstance().reset();

        return Action.INDEX;
    }
}
