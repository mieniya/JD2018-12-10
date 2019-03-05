package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdAdminPanel implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user == null) return Action.LOGIN;
        if (user.getFk_roles() == 1) return Action.ADMINPANEL;
        if (user.getFk_roles() == 2) return Action.PROFILE;
        return Action.INDEX;
    }
}
