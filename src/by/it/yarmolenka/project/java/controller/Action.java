package by.it.yarmolenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {

    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    ERROR(new CmdError()),
    LOGOUT(new CmdLogout()),
    RESET(new CmdReset()),
    REGISTER(new CmdRegister()),
    GETEVENTS(new CmdGetEvents()),
    GETRACES(new CmdGetRaces()),
    CREATEEVENT(new CmdCreateEvent()),
    CREATERACE(new CmdCreateRace()),
    PROFILE(new CmdProfile()),
    ADMINPANEL(new CmdAdminPanel()),
    EDITUSERS(new CmdEditUsers()),
    EDITRACE(new CmdEditRace());

    Cmd command;

    Action(Cmd command){
        this.command = command;
    }

    public static Action define(HttpServletRequest req) {
        String cmd = req.getParameter("command").toUpperCase();
        try {
            return Action.valueOf(cmd);
        } catch (Exception e){
            return Action.ERROR;
        }
    }

    public String getJsp() {
        return "/" + name().toLowerCase() + ".jsp";
    }
}
