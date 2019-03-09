package by.it.titkovskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isGet(req)){
            if (req.getParameter("signup") != null){
                return Action.SIGNUP;
            } else if (req.getParameter("login") != null){
                return Action.LOGIN;
            }
            else if (req.getParameter("changeLang") != null){
                return Action.CHANGELANG;
            }
        }
        return Action.INDEX;
    }
}
