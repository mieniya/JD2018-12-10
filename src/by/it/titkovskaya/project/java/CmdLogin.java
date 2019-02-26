package by.it.titkovskaya.project.java;

import by.it.titkovskaya.project.beans.User;
import by.it.titkovskaya.project.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;
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
                req.setAttribute("user", user);
            }
        }
        return Action.LOGIN;
    }
}
