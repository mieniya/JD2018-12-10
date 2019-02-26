package by.it.titkovskaya.project.java;

import by.it.titkovskaya.project.beans.User;
import by.it.titkovskaya.project.custom_DAO.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {

    @Override
    public Action execute(HttpServletRequest req) throws Exception{
        if (Form.isPost(req)) {
            String login = Form.getString(req, "login", "[A-z0-9_-]{5,}");
            String password = Form.getString(req, "password");
            String email = Form.getString(req, "email");
            String name = Form.getString(req, "name");
            User user = new User(0, login, password, email, name, 2);
            if (Dao.getDao().user.create(user)){
                return Action.INDEX;
            }
        }
        return Action.SIGNUP;
    }
}
