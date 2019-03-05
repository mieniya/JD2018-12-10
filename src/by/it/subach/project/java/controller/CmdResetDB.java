package by.it.subach.project.java.controller;

import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB implements Cmd {


    @Override
    public Action execute(HttpServletRequest req) throws Exception {
//        getInstance().reset();

        if(Form.isPost(req)){
            DAO.getInstance().reset();
        }

        return Action.RESETDB;
    }
}