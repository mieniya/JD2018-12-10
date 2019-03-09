package by.it.titkovskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdChangeLang implements Cmd{

    @Override
    public Action execute(HttpServletRequest req) throws Exception{

        return Action.INDEX;
    }
}
