package by.it.subach.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        return Action.SIGNUP;
    }
}
