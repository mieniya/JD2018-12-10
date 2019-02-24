package by.it.moroz.jd03.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    SIGNUP(new CmdSighUp());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

     static Action define(HttpServletRequest req){
        String command = req.getParameter("command").toUpperCase();

        try{
            return Action.valueOf(command);
        }catch (Exception e){
            return Action.ERROR;
        }

    }

    String getJSP(){
         return "/"+name().toLowerCase()+".jsp";
    }
}
