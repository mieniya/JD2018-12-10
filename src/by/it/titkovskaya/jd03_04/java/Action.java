package by.it.titkovskaya.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX (new CmdIndex()), ERROR (new CmdError()), SINGUP(new CmdSignup());

    Cmd command;

    String getJsp(){
        return "/" + name().toLowerCase() + "jsp";
    }

    Action(Cmd command) {
        this.command = command;
    }

    static Action define(HttpServletRequest req){
        String command = req.getParameter("command").toUpperCase();
        Action action;
        try{
            action = Action.valueOf(command);
        }
        catch (Exception e){
            return Action.ERROR;
        }
        return action;
    }
}
