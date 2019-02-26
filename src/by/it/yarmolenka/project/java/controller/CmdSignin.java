package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdSignin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = Form.getString(req, "login", Patterns.LOGIN);
            String password = Form.getString(req, "password", Patterns.PASSWORD);
            Dao dao = Dao.getDao();
            String sqlWhere = String.format("WHERE `login`='%s' AND `password`='%s'", login, password);
            List<User> users = dao.user.getAll(sqlWhere);
            if (users.size() > 0) {
                User user = users.get(0);
                req.setAttribute("user", user);
                return Action.INDEX;
            }
            return Action.ERROR;
        }
        return Action.SIGNIN;
    }
}
