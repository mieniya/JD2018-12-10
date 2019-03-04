package by.it.skosirskiy.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        req.getSession().invalidate();
        HttpServletResponse resp =
                (HttpServletResponse) req.getAttribute("resp");

        return Action.LOGIN;
    }
}
