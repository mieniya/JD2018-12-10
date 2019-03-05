package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.*;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class Utils {

    static Timestamp getDateTimestamp(HttpServletRequest req) throws ProjectException, ParseException {
        String time = Form.getString(req, "time");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"),
                sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse(time.replace("T", " "));
        return Timestamp.valueOf(sdf2.format(parse));
    }

    static void setServletContextAttributes(ServletContext servletContext) throws SQLException {
        Dao dao = Dao.getDao();
        List<Role> roles = dao.role.getAll();
        List<Race> races = dao.race.getAll();
        List<Event> events = dao.event.getAll();
        servletContext.setAttribute("roles", roles);
        servletContext.setAttribute("races", races);
        servletContext.setAttribute("events", events);
    }

    static User getUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) return null;
        Object oUser = session.getAttribute("user");
        if (oUser == null) return null;
        return (User) oUser;
    }
}
