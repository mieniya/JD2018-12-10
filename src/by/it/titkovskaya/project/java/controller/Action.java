package by.it.titkovskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    PROFILE(new CmdProfile()),
    CREATEACC(new CmdCreateAcc()),
    ACCINFO(new CmdAccInfo()),
    ACCMANAGE(new CmdAccManage()),
    PAYMENT(new CmdPayment()),
    REPLENISH(new CmdReplenish()),
    ACCLOCK(new CmdAccLock()),
    RESETDB(new CmdResetDB()),
    SIGNUP(new CmdSignup());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

    String getJsp() {
        return "/" + name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req) {
        String command = req.getParameter("command").toUpperCase();
        try {
            return Action.valueOf(command);
        } catch (Exception e) {
            return Action.ERROR;
        }
    }
}
