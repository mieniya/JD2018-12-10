package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Action.define(req);
        resp.setHeader("Cache-Control", "no-store");
        try{
            User user = Util.findUser(req);
            if(user!=null){
                Cookie cookie = new Cookie(user.getLogin(), user.getPassword());
                cookie.setMaxAge(60);
                resp.addCookie(cookie);}
            Action nextAction = action.command.execute(req);
            if(nextAction!=action)
                resp.sendRedirect("do?command="+nextAction.name().toLowerCase());
            else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(action.getJSP());
                requestDispatcher.forward(req, resp);
            }
        }catch (Exception e){
            ShowException(req, resp, e);
        }
    }

    private void ShowException(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Action.ERROR.getJSP());
        StackTraceElement[] stackTrace = e.getStackTrace();
        String error = e.toString()+"<hr>"+
                Arrays.toString(stackTrace).replace(",", "<br>");
        req.setAttribute("error",error);
        requestDispatcher.forward(req, resp);
    }
}
