package by.it.naron.jd03_04.java.controller;


import by.it.naron.jd03_04.java.beans.Users;
import by.it.naron.jd03_04.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "e-mail");
            Users user = new Users(0, login, email, password, 2);
            Dao dao = Dao.getDao();
            if (dao.users.create(user)) {
                return Action.INDEX;
            }
        }
        return Action.SIGNUP;
    }
}
