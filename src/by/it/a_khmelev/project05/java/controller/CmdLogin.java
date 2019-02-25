package by.it.a_khmelev.project05.java.controller;

import by.it.a_khmelev.project05.java.beans.User;
import by.it.a_khmelev.project05.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[a-zA-Z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            Dao dao = Dao.getDao();
            String where = String.format(
                    " WHERE `login`='%s' AND `password`='%s'",
                    login, password);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                User user = users.get(0);
                req.setAttribute("user",user);
            }
        }

        return Action.LOGIN;

    }
}
