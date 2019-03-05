package by.it.yarmolenka.project.java.controller;

import by.it.yarmolenka.project.java.beans.Event;
import by.it.yarmolenka.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdCreateEvent implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            Event newEvent = new Event();
            newEvent.setDescription(Form.getString(req, "description", Patterns.TEXT));
            double odds = Form.getDouble(req, "odds");
            if (odds < 0) {
                //todo
                req.setAttribute("oddsInput", "");
                return Action.GETEVENTS;
            }
            newEvent.setOdds(odds);
            long fk_races = Form.getLong(req, "selectrace");
            newEvent.setFk_races(fk_races);
            Dao dao = Dao.getDao();
            if (newEvent.getFk_races() > 0)
                dao.event.create(newEvent);
            return Action.CREATEEVENT;
        }
        return Action.CREATEEVENT;
    }
}
