package by.it.titkovskaya.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Cache-Control", "no-cache");
        Action action = Action.define(req);
        try {
            Action nextAction = action.command.execute(req);

            //********************
            Cookie test = new Cookie("test", "user+pas+hash");
            test.setMaxAge(60);
            resp.addCookie(test);
            //********************

            if (nextAction == action) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(action.getJsp());
                requestDispatcher.forward(req, resp);
            } else {
                resp.sendRedirect("do?command=" + nextAction.name().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/*
resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

response.setHeader("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Cache-Control", "post-check=0,pre-check=0");
response.setHeader("Cache-Control", "max-age=0");
response.setHeader("Pragma", "no-cache");
 */