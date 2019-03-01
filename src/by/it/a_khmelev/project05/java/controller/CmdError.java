package by.it.a_khmelev.project05.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        return Action.ERROR;
    }
}
