package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Event;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdGetEvents implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getDao();
        List<Event> events = dao.event.getAll();
        StringBuilder table = Utils.getEventsTable(events);
        req.setAttribute("events", table.toString());
        return Action.GETEVENTS;
    }
}
