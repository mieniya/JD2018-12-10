package by.it.subach.project.java;

import javax.servlet.http.HttpServletRequest;

public interface Cmd {
    Action execute(HttpServletRequest req) throws Exception;
}
