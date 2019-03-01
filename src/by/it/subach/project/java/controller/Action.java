package by.it.subach.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    SIGNUP(new CmdSignup()),
    RESETDB(new CmdResetDB()),
    CHECKOUT(new CmdCheckout()),
    CATEGORY(new CmdCategory()),
    CREATEPRODUCT(new CmdNewProduct()),
    PROFILE(new CmdProfile()),
    LOGOUT(new CmdLogout()),
    LOGIN(new CmdLogin());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

    String getJsp(){
        return "/"+name().toLowerCase()+".jsp";
    }

    static Action define(HttpServletRequest req){
        String command = req.getParameter("command").toUpperCase();
        try {
            return Action.valueOf(command);
        }
        catch (Exception e){
            return Action.INDEX;
        }
    }


}
