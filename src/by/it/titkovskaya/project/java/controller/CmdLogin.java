package by.it.titkovskaya.project.java.controller;

import by.it.titkovskaya.project.java.beans.User;
import by.it.titkovskaya.project.java.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[A-z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            String where = String.format(
                    " WHERE `login`='%s' AND `password`='%s'", login, password);
            List<User> users = Dao.getDao().user.getAll(where);
            if (users.size() > 0) {
                User user = users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(30);
                return Action.PROFILE;
            }
        }
        return Action.LOGIN;
    }
}
