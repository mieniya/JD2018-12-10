package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

class CmdRegister implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = Form.getString(req, "login", Patterns.LOGIN);
            Dao dao = Dao.getDao();
            List<User> users = dao.user.getAll(String.format("WHERE `login`='%s'", login));
            if (users.size() > 0){
                String error = "User with login \"" + login + "\" already exists";
                req.setAttribute("loginExists", error);
                return Action.REGISTER;
            } else{
                String email = Form.getString(req, "email", Patterns.EMAIL);
                String password = Form.getString(req, "password", Patterns.PASSWORD);
                User newUser = new User(0, login, email, password, 0, 2);
                if (dao.user.create(newUser)) {
                    req.getSession().setAttribute("user", newUser);
                    resp.addCookie(new Cookie("login", newUser.getLogin()));
                    return Action.PROFILE;
                }
                else throw new ProjectException("Can not create user " + newUser);
            }
        }
        return Action.REGISTER;
    }
}
