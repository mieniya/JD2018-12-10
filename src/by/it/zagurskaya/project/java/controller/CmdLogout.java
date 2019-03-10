package by.it.zagurskaya.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        req.getSession().invalidate();
        return Action.LOGIN;
    }
}
