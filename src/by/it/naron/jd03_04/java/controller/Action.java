package by.it.naron.jd03_04.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    LOGIN(new CmdLogin()),
    CREATEGOODSFLOWER(new CmdCreateGoodsflower()),
    CREATEORDERS(new CmdCreateOrders()),
    RESETDB(new CmdResetDB()),
    SIGNUP(new CmdSignup());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

    String getJsp(){
        return "/"+name().toLowerCase()+".jsp";
    }

    static Action define(HttpServletRequest req){
        String command = req.getParameter("command").toUpperCase((Locale.ENGLISH));
        try {
            return Action.valueOf(command);
        }
        catch (Exception e){
            return Action.ERROR;
        }
    }


}
