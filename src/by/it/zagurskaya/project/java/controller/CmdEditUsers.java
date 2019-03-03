package by.it.zagurskaya.project.java.controller;

import by.it.zagurskaya.project.java.beans.User;
import by.it.zagurskaya.project.java.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CmdEditUsers implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
//        Dao dao = Dao.getDao();
//        UserDao userDao = new UserDao();
//        User user = new User();
        if (Form.isPost(req)){
            long id = Form.getLong(req, "id");
            String login = Form.getString(req, "login");
            String password = Form.getString(req, "password");
//            String email = Form.getString(req, "email");
            long roleId = Form.getLong(req, "roleId");
            User user = new User(id, login, password, roleId);
            if (req.getParameter("update")!=null){
//                userDao.update(user);
                new UserDao().update(user);
            }
            else if (req.getParameter("delete")!=null){
//                userDao.delete(user);
                new UserDao().delete(user);
            }
        }

//        List<User> users = Dao.getDao().user.getAll();
        List<User> users = new ArrayList<User>();
        UserDao userDao = new UserDao();
        users.addAll(userDao.getAll());
        req.setAttribute("users",users);
        return Action.EDITUSERS;
    }
}
