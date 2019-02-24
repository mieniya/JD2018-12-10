package by.it.moroz.jd03.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public interface Cmd {

    Action execute(HttpServletRequest req) throws Exception;

}
