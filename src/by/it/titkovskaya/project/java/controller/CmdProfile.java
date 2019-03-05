package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.Account;
import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if (user != null) {
            if (Form.isGet(req)) {
                if (req.getParameter("createAcc") != null){
                    return Action.CREATEACC;
                }
                else if (req.getParameter("accTrans") != null){
                    return Action.ACCTRANS;
                }
                else if (req.getParameter("accInfo") != null){
                    return Action.ACCINFO;
                }
                else if (req.getParameter("accLock") != null){
                    return Action.ACCLOCK;
                }
                else if (req.getParameter("userData") != null){
                    return Action.USERDATA;
                }
                else if (req.getParameter("logout") != null){
                    return Action.LOGOUT;
                }
            }
            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
