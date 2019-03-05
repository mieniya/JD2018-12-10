package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.User;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Utils.getUser(req);
        if (user != null){
            Dao dao = Dao.getDao();
            String where = String.format("WHERE `fk_users`='%d'", user.getId());
            HttpSession session = req.getSession();
            session.setAttribute("userBets", dao.bet.getAll(where));
            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
