package by.it.moroz.jd03.progect.java;

import javax.servlet.http.HttpServletRequest;

public interface Cmd {

    Action execute(HttpServletRequest req) throws Exception;

}
