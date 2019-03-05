package by.it.yarmolenka.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().invalidate();
        Cookie cookie = new Cookie("user", "");
        resp.addCookie(cookie);
        return Action.LOGIN;
    }
}
