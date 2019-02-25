package by.it.moroz.jd03.progect.java;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.INDEX;
    }
}
