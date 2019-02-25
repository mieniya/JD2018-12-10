package by.it.moroz.jd03.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
