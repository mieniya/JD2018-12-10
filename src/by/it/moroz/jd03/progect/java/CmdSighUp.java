package by.it.moroz.jd03.progect.java;

import javax.servlet.http.HttpServletRequest;

public class CmdSighUp implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.SIGNUP;
    }
}
