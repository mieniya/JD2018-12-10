package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return null;
        }
        Object oUser = req.getSession().getAttribute("user");
        if (oUser == null){
            return null;
        }
        else
            return (User) oUser;
    }

}
